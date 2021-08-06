package team.healthtech.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.db.repository.AppointmentRepository;
import team.healthtech.db.repository.TimeRecordsRepository;
import team.healthtech.service.mapper.AppointmentMapper;
import team.healthtech.service.model.create_dto.AppointmentCreateDto;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.logic.AppointmentService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final TimeRecordsRepository timeRecordsRepository;
    private final AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentServiceImpl(
        AppointmentRepository appointmentRepository,
        TimeRecordsRepository timeRecordsRepository,
        AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.timeRecordsRepository = timeRecordsRepository;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public AppointmentDto createAppointment(@Valid AppointmentCreateDto appointmentCreateDto, Integer patientId) {
        AppointmentEntity entity = appointmentMapper.toEntity(appointmentCreateDto, patientId);
        Integer doctorId = appointmentCreateDto.getDoctorId();

        entity.setTimeRecord(timeRecordsRepository.getTimeRecordEntityByDoctorId(doctorId));

        return appointmentMapper.fromEntity(appointmentRepository.save(entity));
    }

    @Override
    public List<AppointmentDto> getAppointmentsOfPatientById(Integer patientId) {
        return appointmentMapper.fromEntities(appointmentRepository.getAllByPatientId(patientId));
    }

}
