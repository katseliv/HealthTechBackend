package team.healthtech.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.entity.DiseaseEntity;
import team.healthtech.db.repository.DiseaseRepository;
import team.healthtech.service.logic.PatientDiseasesService;
import team.healthtech.service.mapper.DiseaseMapper;
import team.healthtech.service.model.create_dto.DiseaseCreateDto;
import team.healthtech.service.model.DiseaseDto;
import team.healthtech.service.model.update_dto.DiseaseUpdateDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientDiseasesServiceImpl implements PatientDiseasesService {

    private final DiseaseMapper mapper;
    private final DiseaseRepository repository;

    @Autowired
    public PatientDiseasesServiceImpl(
        DiseaseMapper mapper,
        DiseaseRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public DiseaseDto createDisease(DiseaseCreateDto dto) {
        DiseaseEntity entity = repository.save(mapper.toEntity(dto));
        return Optional.of(entity)
            .map(repository::save)
            .map(mapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public void updateDisease(DiseaseUpdateDto diseaseDto, int diseaseId) {
        DiseaseEntity entity = repository.findById(diseaseId).orElseThrow();
        mapper.merge(diseaseDto, entity);
        repository.save(entity);
    }

    @Override
    public void deleteDisease(int diseaseId) {
        repository.deleteById(diseaseId);
    }

    @Override
    public DiseaseDto getDiseaseById(int diseaseId) {
        return repository.findById(diseaseId)
            .map(mapper::fromEntity)
            .orElse(null);
    }

    @Override
    public List<DiseaseDto> getAllDiseases(int patientId) {
        List<DiseaseEntity> list = repository.getAllDiseasesByPatientId(patientId);
        return mapper.fromEntities(list);
    }

}
