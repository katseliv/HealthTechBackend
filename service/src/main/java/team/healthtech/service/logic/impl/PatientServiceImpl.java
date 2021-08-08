package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import team.healthtech.common.Role;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.db.repository.PatientRepository;
import team.healthtech.service.logic.PatientService;
import team.healthtech.service.mapper.PatientMapper;
import team.healthtech.service.model.PatientDto;
import team.healthtech.service.model.create_dto.PatientCreateDto;
import team.healthtech.service.security.HealthtechPasswordEncoder;
import team.healthtech.service.security.Profile;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class PatientServiceImpl implements PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);
    private final ObjectProvider<Profile> profileProvider;
    private final HealthtechPasswordEncoder passwordEncoder;
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Autowired
    public PatientServiceImpl(
        ObjectProvider<Profile> profileProvider,
        HealthtechPasswordEncoder passwordEncoder,
        PatientRepository patientRepository,
        PatientMapper patientMapper
    ) {
        this.profileProvider = profileProvider;
        this.passwordEncoder = passwordEncoder;
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public PatientDto createPatient(@Valid PatientCreateDto patientDto) {
        if (profileProvider.getIfAvailable() == null) {
            logger.info("Create new Patient by anonymous");
        } else {
            logger.info("Create new Patient by {}", profileProvider.getIfAvailable());
        }

        String encodePassword = passwordEncoder.encode(patientDto.getPassword());
        patientDto.setPassword(encodePassword);
        patientDto.setRole(Role.PATIENT);
        PatientDto dto = Optional.of(patientDto)
            .map(patientMapper::toEntity)
            .map(patientRepository::save)
            .map(patientMapper::fromEntity)
            .orElseThrow();

        dto.setAge(getAgeOfPatient(patientMapper.toEntity(patientDto).getId()));

        return dto;
    }

    @Override
    @Transactional
    public void updatePatient(PatientDto patientDto, int patientId) {
        PatientEntity entity = patientRepository.findById(patientId).orElseThrow();
        patientMapper.merge(patientDto, entity);
        patientRepository.save(entity);
    }

    @Override
    public PatientDto getPatientById(int patientId) {
        PatientDto patientDto = patientMapper.fromEntity(patientRepository.findById(patientId).orElse(null));
        patientDto.setAge(getAgeOfPatient(patientId));
        return patientDto;
    }

    @Override
    public void deletePatientById(int patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<PatientDto> patients = patientMapper.fromEntities(patientRepository.findAll());
        for (var patient : patients) {
            patient.setAge(getAgeOfPatient(patient.getId()));
        }
        return patients;
    }

    private Integer getAgeOfPatient(Integer patientId) {
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
        return Period.between(
            patient.getBirthdate().toLocalDate(),
            new Date(System.currentTimeMillis()).toLocalDate()
        ).getYears();
    }
}
