package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import team.healthtech.db.repository.SpecialityRepository;
import team.healthtech.service.logic.SpecialityService;
import team.healthtech.service.mapper.SpecialityMapper;
import team.healthtech.service.model.SpecialityDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    private static final Logger logger = LoggerFactory.getLogger(SpecialityServiceImpl.class);
    private final SpecialityRepository specialityRepository;
    private final SpecialityMapper specialityMapper;

    public SpecialityServiceImpl(
        SpecialityRepository specialityRepository,
        SpecialityMapper specialityMapper
    ) {
        this.specialityRepository = specialityRepository;
        this.specialityMapper = specialityMapper;
    }

    @Override
    public void createSpeciality(SpecialityDto specialityDto) {
        logger.info("New speciality create request");
        specialityRepository.save(specialityMapper.toEntity(specialityDto));
    }

    @Override
    public List<SpecialityDto> getAllSpecialities() {
        logger.info("All specialities get request");
        List<SpecialityDto> specialities = new ArrayList<>();
        for (var speciality : specialityRepository.findAll()) {
            specialities.add(specialityMapper.fromEntity(speciality));
        }
        return specialities;
    }
}
