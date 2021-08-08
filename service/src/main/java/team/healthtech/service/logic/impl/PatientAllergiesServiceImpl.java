package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.entity.AllergyEntity;
import team.healthtech.db.repository.AllergyRepository;
import team.healthtech.db.repository.PatientRepository;
import team.healthtech.service.EntityNotFoundException;
import team.healthtech.service.logic.PatientAllergiesService;
import team.healthtech.service.mapper.AllergyMapper;
import team.healthtech.service.mapper.PatientMapper;
import team.healthtech.service.model.AllergyDto;
import team.healthtech.service.security.Profile;

import javax.validation.Valid;
import java.util.List;

@Service
public class PatientAllergiesServiceImpl implements PatientAllergiesService {

    private static final Logger logger = LoggerFactory.getLogger(PatientAllergiesServiceImpl.class);
    private final ObjectProvider<Profile> profileProvider;
    private final AllergyRepository allergyRepository;
    private final PatientRepository patientRepository;
    private final AllergyMapper allergyMapper;
    private final PatientMapper patientMapper;

    @Autowired
    public PatientAllergiesServiceImpl(
        ObjectProvider<Profile> profileProvider, AllergyRepository allergyRepository,
        PatientRepository patientRepository,
        AllergyMapper allergyMapper,
        PatientMapper patientMapper) {
        this.profileProvider = profileProvider;
        this.allergyRepository = allergyRepository;
        this.patientRepository = patientRepository;
        this.allergyMapper = allergyMapper;
        this.patientMapper = patientMapper;
    }

    @Override
    public void addAllergyToPatient(@Valid int allergyId, int patientId) {
        logger.info(
            "Allergy with id {} to patient with id {} add request by {}",
            allergyId,
            patientId,
            profileProvider.getIfAvailable()
        );
        var allergyDto = allergyMapper.fromEntity(allergyRepository.getById(allergyId));
        if (allergyRepository.getAllAllergiesByPatientId(patientId).contains(allergyMapper.toEntity(allergyDto))) {
            var patientEntity = patientRepository.findById(patientId).orElseThrow(
                () -> new EntityNotFoundException(patientId, "User")
            );
            var patientDto = patientRepository.findById(patientId).map(patientMapper::fromEntity).orElseThrow();
            List<AllergyDto> list = patientDto.getAllergies();
            list.add(allergyDto);
            patientDto.setAllergies(list);

            patientMapper.merge(patientDto, patientEntity);
            patientRepository.save(patientEntity);
        }
        // мы молчим, когда идет попытка присвоить уже существующую аллергию

        //patientMapper.toEntity(patientDto, patientEntity);
        //patientRepository.save(patientEntity);
    }

    @Override
    public void deleteAllergyFromPatient(int allergyId, int patientId) {
        logger.info(
            "Allergy with id {} to patient with id {} delete request by {}",
            allergyId,
            patientId,
            profileProvider.getIfAvailable()
        );
        AllergyEntity entity = allergyRepository.getAllergyFromPatientById(allergyId, patientId);
        var patientEntity = patientRepository.findById(patientId).orElseThrow(
            () -> new EntityNotFoundException(patientId, "User")
        );
        patientEntity.getAllergies().remove(entity);
        patientRepository.save(patientEntity);
    }

    @Override
    public List<AllergyDto> getAllAllergiesFromPatient(int patientId) {
        logger.info(
            "Allergies list from patient with id {} get request by {}",
            patientId,
            profileProvider.getIfAvailable()
        );
        return allergyMapper.fromEntities(allergyRepository.getAllAllergiesByPatientId(patientId));
    }

    @Override
    public AllergyDto getAllergyById(int allergyId) {
        return allergyRepository.findById(allergyId)
            .map(allergyMapper::fromEntity)
            .orElse(null);
    }
}

