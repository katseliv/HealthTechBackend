package team.healthtech.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.repository.AppointmentRepository;
import team.healthtech.service.mapper.AppointmentMapper;
import team.healthtech.service.model.AppointmentCreateDto;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.logic.AppointmentService;

import java.util.List;

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
        return
            appointmentMapper.fromEntity(
                appointmentRepository.save(
                    appointmentMapper.toEntity(appointmentCreateDto, patientId)));
    }

    @Override
    public List<AppointmentDto> getAppointmentsOfPatientById(Integer patientId) {
        return appointmentMapper.fromEntities(appointmentRepository.getAllByPatientId(patientId));
    }

}
