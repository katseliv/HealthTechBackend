package team.healthtech.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.entity.DiseaseEntity;
import team.healthtech.db.repository.DiseaseRepository;
import team.healthtech.service.logic.PatientDiseasesService;
import team.healthtech.service.mapper.DiseaseMapper;
import team.healthtech.service.model.create_dto.DiseaseCreateDto;
import team.healthtech.service.model.DiseaseDto;

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
    public void updateDisease(DiseaseDto diseaseDto, int diseaseId) {
        mapper.merge(diseaseDto, repository.findById(diseaseId).orElseThrow());
        repository.save(mapper.toEntity(diseaseDto));
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
        return mapper.fromEntities(repository.getAllDiseasesByPatientId(patientId));
    }

}
