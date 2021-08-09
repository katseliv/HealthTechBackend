package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.db.repository.AppointmentRepository;
import team.healthtech.db.repository.TimeRecordsRepository;
import team.healthtech.service.mapper.AppointmentMapper;
import team.healthtech.service.model.create_dto.AppointmentCreateDto;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.logic.AppointmentService;
import team.healthtech.service.security.Profile;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class AppointmentServiceImpl implements AppointmentService {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentServiceImpl.class);
    private final AppointmentRepository appointmentRepository;
    private final TimeRecordsRepository timeRecordsRepository;
    private final AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentServiceImpl(
        AppointmentRepository appointmentRepository,
        TimeRecordsRepository timeRecordsRepository,
        AppointmentMapper appointmentMapper
    ) {
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
    public void updateAppointment(AppointmentCreateDto appointmentCreateDto, Integer appointmentId) {
        AppointmentEntity entity = appointmentRepository.findById(appointmentId).orElseThrow();
        appointmentMapper.merge(appointmentCreateDto, entity);
        appointmentRepository.save(appointmentMapper.toEntity(appointmentCreateDto));
    }

    @Override
    public List<AppointmentDto> getAppointmentsOfPatientById(Integer patientId) {
        return appointmentMapper.fromEntities(appointmentRepository.getAllByPatientId(patientId));
    }

}
