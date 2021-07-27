package team.healthtech.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.repository.AppointmentRepository;
import team.healthtech.db.repository.PatientRepository;
import team.healthtech.service.mapper.AppointmentMapper;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.logic.AppointmentService;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto, int patientId) {
//        appointmentRepository.findById(patientId);
//        appointmentDto.getPatient().setId(patientId);
        return Optional.of(appointmentDto)
            .map(appointmentMapper::toEntity)
            .map(appointmentRepository::save)
            .map(appointmentMapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public List<AppointmentDto> getAppointmentsOfPatientById(int patientId) {
        patientRepository.findById(patientId);
        return null;
    }

}
