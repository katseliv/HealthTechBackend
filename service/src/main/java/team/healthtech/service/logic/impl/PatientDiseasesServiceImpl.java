package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.entity.DiseaseEntity;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.db.repository.DiseaseRepository;
import team.healthtech.db.repository.PatientRepository;
import team.healthtech.service.logic.PatientDiseasesService;
import team.healthtech.service.mapper.DiseaseMapper;
import team.healthtech.service.model.create_dto.DiseaseCreateDto;
import team.healthtech.service.model.DiseaseDto;
import team.healthtech.service.model.update_dto.DiseaseUpdateDto;
import team.healthtech.service.security.Profile;

import javax.validation.Valid;
import java.util.List;

@Service
public class PatientDiseasesServiceImpl implements PatientDiseasesService {

    private static final Logger logger = LoggerFactory.getLogger(PatientDiseasesServiceImpl.class);
    private final ObjectProvider<Profile> profileProvider;
    private final DiseaseMapper mapper;
    private final DiseaseRepository repository;
    private final PatientRepository patientRepository;

    @Autowired
    public PatientDiseasesServiceImpl(
        ObjectProvider<Profile> profileProvider, DiseaseMapper mapper,
        DiseaseRepository repository, PatientRepository patientRepository) {
        this.profileProvider = profileProvider;
        this.mapper = mapper;
        this.repository = repository;
        this.patientRepository = patientRepository;
    }

    @Override
    public DiseaseDto createDisease(@Valid DiseaseCreateDto dto) {
        logger.info("New disease create request by {}", profileProvider.getIfAvailable());
        DiseaseEntity entity = mapper.toEntity(dto);
        PatientEntity patient = patientRepository.findById(dto.getPatientId()).orElseThrow();
        entity.setPatient(patient);
        DiseaseEntity e = repository.save(entity);
        return mapper.fromEntity(e);
    }

    @Override
    public void updateDisease(@Valid DiseaseUpdateDto diseaseDto, int diseaseId) {
        logger.info("Disease with id {} update request by {}", diseaseId, profileProvider.getIfAvailable());
        DiseaseEntity entity = repository.findById(diseaseId).orElseThrow();
        mapper.merge(diseaseDto, entity);
        repository.save(entity);
    }

    @Override
    public void deleteDisease(int diseaseId) {
        logger.info("Disease with id {} delete request by {}", diseaseId, profileProvider.getIfAvailable());
        repository.deleteById(diseaseId);
    }

    @Override
    public DiseaseDto getDiseaseById(int diseaseId) {
        logger.info("Disease with id {} get request by {}", diseaseId, profileProvider.getIfAvailable());
        return repository.findById(diseaseId)
            .map(mapper::fromEntity)
            .orElse(null);
    }

    @Override
    public List<DiseaseDto> getAllDiseases(int patientId) {
        logger.info("Diseases list get request by {}", profileProvider.getIfAvailable());
        List<DiseaseEntity> list = repository.getAllDiseasesByPatientId(patientId);
        return mapper.fromEntities(list);
    }

}
