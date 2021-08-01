package team.healthtech.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import team.healthtech.db.repository.DiseaseRepository;
import team.healthtech.service.logic.PatientDiseasesService;
import team.healthtech.service.mapper.DiseaseCreateMapper;
import team.healthtech.service.mapper.DiseaseUpdateMapper;
import team.healthtech.service.model.DiseaseCreateDto;
import team.healthtech.service.model.DiseaseDto;
import team.healthtech.service.model.PatientDto;

import java.util.List;
import java.util.Optional;

public class PatientDiseasesServiceImpl implements PatientDiseasesService {
    private final DiseaseCreateMapper createMapper;
    private final DiseaseUpdateMapper updateMapper;
    private final DiseaseRepository repository;

    @Autowired
    public PatientDiseasesServiceImpl(DiseaseCreateMapper createMapper,
                                      DiseaseUpdateMapper updateMapper,
                                      DiseaseRepository repository) {
        this.createMapper = createMapper;
        this.updateMapper = updateMapper;
        this.repository = repository;
    }

    @Override
    public DiseaseCreateDto createDisease(DiseaseCreateDto disease) {
        return Optional.ofNullable(disease)
            .map(createMapper::toEntity)
            .map(repository::save)
            .map(createMapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public void updateDisease(DiseaseDto diseaseDto, int diseaseId) {
        updateMapper.merge(diseaseDto, repository.findById(diseaseId).orElseThrow());
        repository.save(updateMapper.toEntity(diseaseDto));
    }

    @Override
    public void deleteDisease(int diseaseId) {

    }

    @Override
    public DiseaseDto getDiseaseById(int diseaseId) {
        return null;
    }

    @Override
    public List<DiseaseDto> getAllDiseases(int patientId) {
        return null;
    }
}
