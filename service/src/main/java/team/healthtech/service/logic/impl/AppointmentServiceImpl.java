package team.healthtech.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.repository.AppointmentRepository;
import team.healthtech.db.repository.PatientRepository;
import team.healthtech.service.mapper.AppointmentMapper;
import team.healthtech.service.mapper.PatientMapper;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.logic.AppointmentService;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final AppointmentMapper appointmentMapper;
    private final PatientMapper patientMapper;

    @Autowired
    public AppointmentServiceImpl(
        AppointmentRepository appointmentRepository,
        PatientRepository patientRepository,
        AppointmentMapper appointmentMapper,
        PatientMapper patientMapper) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.appointmentMapper = appointmentMapper;
        this.patientMapper = patientMapper;
    }

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto, int patientId) {
        appointmentDto.setPatient(
            patientMapper.fromEntity(
                patientRepository.findById(patientId).orElseThrow()));

        return Optional.of(appointmentDto)
            .map(appointmentMapper::toEntity)
            .map(appointmentRepository::save)
            .map(appointmentMapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public List<AppointmentDto> getAppointmentsOfPatientById(int patientId) {
        return appointmentMapper.fromEntities(appointmentRepository.findAllByPatientId(patientId));
    }

//    questionable
//    @Override
//    public AppointmentDto createAppointment(AppointmentCreateDto appointmentDto, int patientId) {
//        AppointmentEntity appointmentEntity = new AppointmentEntity();
//        appointmentEntity.setPatient(patientRepository.findById(patientId).orElseThrow());
//        appointmentEntity.setId(patientId);
////        appointmentDto.setPatient(patientRepository.findById(patientId).orElseThrow());
//
//        return Optional.of(appointmentDto)
//            .map(appointmentMapper::toEntity)
//            .map(appointmentRepository::save)
//            .map(appointmentMapper::fromEntity)
//            .orElseThrow();
//    }

}
