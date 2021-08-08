package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import team.healthtech.db.repository.PatientRepository;
import team.healthtech.db.repository.SpecialityRepository;
import team.healthtech.service.logic.SpecialityService;
import team.healthtech.service.mapper.PatientMapper;
import team.healthtech.service.mapper.SpecialityMapper;
import team.healthtech.service.model.SpecialityDto;
import team.healthtech.service.security.HealthtechPasswordEncoder;
import team.healthtech.service.security.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);
    private final SpecialityRepository specialityRepository;
    private final SpecialityMapper specialityMapper;

    public SpecialityServiceImpl(SpecialityRepository specialityRepository, SpecialityMapper specialityMapper) {
        this.specialityRepository = specialityRepository;
        this.specialityMapper = specialityMapper;
    }

    @Override
    public SpecialityDto createSpeciality(SpecialityDto specialityDto) {
        specialityRepository.save(specialityMapper.toEntity(specialityDto));
        return specialityDto;
    }

    @Override
    public List<SpecialityDto> getAllSpecialities() {
        List<SpecialityDto> specialities = new ArrayList<>();
        for (var speciality : specialityRepository.findAll()) {
            specialities.add(specialityMapper.fromEntity(speciality));
        }
        return specialities;
    }
}
