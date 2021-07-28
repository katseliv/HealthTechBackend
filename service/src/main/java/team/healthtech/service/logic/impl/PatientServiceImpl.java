package team.healthtech.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.repository.PatientRepository;
import team.healthtech.service.logic.PatientService;
import team.healthtech.service.mapper.PatientMapper;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.model.PatientDto;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        return Optional.of(patientDto)
            .map(patientMapper::toEntity)
            .map(patientRepository::save)
            .map(patientMapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public void updatePatient(PatientDto patientDto, int patientId) {
//        patientRepository.save()
        patientMapper.merge(patientDto, patientRepository.findById(patientId).orElseThrow());
    }

    @Override
    public PatientDto getPatientById(int patientId) {
        return patientRepository.findById(patientId)
            .map(patientMapper::fromEntity)
            .orElse(null);
    }

    @Override
    public void deletePatientById(int patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        return patientMapper.fromEntities(patientRepository.findAll());
    }

    @Override
    public List<AppointmentDto> getAppointmentsOfPatientById(int patientId) {
        return null;
    }

}