package team.healthtech.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.repository.DiseaseRepository;
import team.healthtech.service.logic.PatientDiseasesService;
import team.healthtech.service.mapper.DiseaseCreateMapper;
import team.healthtech.service.mapper.DiseaseUpdateMapper;
import team.healthtech.service.model.DiseaseCreateDto;
import team.healthtech.service.model.DiseaseDto;
import team.healthtech.service.model.PatientDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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
        repository.deleteById(diseaseId);
    }

    @Override
    public DiseaseDto getDiseaseById(int diseaseId) {
        return repository.findById(diseaseId)
            .map(updateMapper::fromEntity)
            .orElse(null);
    }

    @Override
    public List<DiseaseDto> getAllDiseases(int patientId) {
        // what's going on people?
        List<DiseaseDto> list = new ArrayList<>();

        repository.findAll().forEach(diseaseEntity -> {
            if (diseaseEntity.getPatient().getId() == patientId)
                list.add(updateMapper.fromEntity(diseaseEntity));
        });
        return list;
    }
}
