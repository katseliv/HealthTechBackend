package team.healthtech.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.db.entity.TimeRecordEntity;
import team.healthtech.db.repository.AppointmentRepository;
import team.healthtech.db.repository.TimeRecordsRepository;
import team.healthtech.service.mapper.AppointmentMapper;
import team.healthtech.service.model.AppointmentCreateDto;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.logic.AppointmentService;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentServiceImpl(
        AppointmentRepository appointmentRepository,
        AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public AppointmentDto createAppointment(AppointmentCreateDto appointmentCreateDto, Integer patientId) {
// Когда мы создаём визит, то указывая patientId, будет ли он жаловаться на то, что пациента нет

//        1 Option
//        TimeRecordEntity timeRecordEntity = timeRecordsRepository.getTimeRecordEntityByDoctorId(
//            appointmentCreateDto.getDoctorId()
//        );
//        AppointmentEntity appointmentEntity =
//            appointmentMapper.toEntity(appointmentCreateDto, timeRecordEntity);


        AppointmentEntity appointmentEntity =
            appointmentRepository.save(
                appointmentMapper.toEntity(appointmentCreateDto, patientId)
            );


//        return appointmentMapper.fromEntity(appointmentEntity);

        return Optional.of(appointmentEntity)
            .map(appointmentRepository::save)
            .map(appointmentMapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public List<AppointmentDto> getAppointmentsOfPatientById(Integer patientId) {
        return appointmentMapper.fromEntities(appointmentRepository.getAllByPatientId(patientId));
    }

}
