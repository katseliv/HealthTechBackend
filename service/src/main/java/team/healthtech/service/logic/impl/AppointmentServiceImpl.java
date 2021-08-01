package team.healthtech.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.repository.AppointmentRepository;
import team.healthtech.db.repository.PatientRepository;
import team.healthtech.db.repository.TimeRecordsRepository;
import team.healthtech.service.mapper.AppointmentCreateMapper;
import team.healthtech.service.mapper.AppointmentMapper;
import team.healthtech.service.mapper.PatientMapper;
import team.healthtech.service.mapper.TimeRecordMapper;
import team.healthtech.service.model.AppointmentCreateDto;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.logic.AppointmentService;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final TimeRecordsRepository timeRecordsRepository;
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final TimeRecordMapper timeRecordMapper;
    private final AppointmentCreateMapper appointmentCreateMapper;
    private final AppointmentMapper appointmentMapper;
    private final PatientMapper patientMapper;

    @Autowired
    public AppointmentServiceImpl(
        TimeRecordsRepository timeRecordsRepository, AppointmentRepository appointmentRepository,
        PatientRepository patientRepository,
        TimeRecordMapper timeRecordMapper, AppointmentCreateMapper appointmentCreateMapper,
        AppointmentMapper appointmentMapper, PatientMapper patientMapper) {
        this.timeRecordsRepository = timeRecordsRepository;
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.timeRecordMapper = timeRecordMapper;
        this.appointmentCreateMapper = appointmentCreateMapper;
        this.appointmentMapper = appointmentMapper;
        this.patientMapper = patientMapper;
    }

//    questionable
    @Override
    public AppointmentDto createAppointment(AppointmentCreateDto appointmentCreateDto, int patientId) {
        AppointmentDto appointmentDto = appointmentCreateMapper.toAppointmentDto(appointmentCreateDto);
        appointmentDto.setPatient(
            patientMapper.fromEntity(patientRepository.findById(patientId).orElseThrow())
        );
        appointmentDto.setTimeRecordDto(
            timeRecordMapper.fromEntity(
                timeRecordsRepository.getTimeRecordEntityByDoctorId(appointmentCreateDto.getDoctorId())
            )
        );

        return Optional.of(appointmentDto)
            .map(appointmentMapper::toEntity)
            .map(appointmentRepository::save)
            .map(appointmentMapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public List<AppointmentDto> getAppointmentsOfPatientById(int patientId) {
        return appointmentMapper.fromEntities(appointmentRepository.getAllByPatientId(patientId));
    }

}
