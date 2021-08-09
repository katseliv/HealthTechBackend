package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.entity.DoctorEntity;
import team.healthtech.db.entity.DoctorSpecialityId;
import team.healthtech.db.entity.DoctorsSpecialitiesEntity;
import team.healthtech.db.repository.DoctorsSpecialitiesRepository;
import team.healthtech.db.repository.SpecialityRepository;
import team.healthtech.service.logic.DoctorSpecialitiesService;
import team.healthtech.service.mapper.DoctorSpecialitiesMapper;
import team.healthtech.service.model.DoctorSpecialitiesDto;

import java.sql.Date;
import java.util.List;

@Service
public class DoctorSpecialitiesServiceImpl implements DoctorSpecialitiesService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorSpecialitiesServiceImpl.class);
    private final DoctorsSpecialitiesRepository repository;
    private final DoctorSpecialitiesMapper mapper;

    @Autowired
    public DoctorSpecialitiesServiceImpl(
        DoctorsSpecialitiesRepository doctorsSpecialitiesRepository,
        DoctorSpecialitiesMapper mapper) {
        this.repository = doctorsSpecialitiesRepository;
        this.mapper = mapper;
    }

    @Override
    public void addSpecialityByDoctorId(DoctorSpecialitiesDto dto, Integer doctorId) {
        logger.info(
            "Speciality with id {} to doctor with id {} add request",
            dto.getSpecialityId(),
            doctorId
        );
        var entity = mapper.toEntity(dto, doctorId);
        repository.save(entity);
    }

    @Override
    public List<DoctorSpecialitiesDto> getAllSpecialitiesByDoctorId(Integer doctorId) {
        logger.info("All specialities of doctor with id {} get request", doctorId);
        return mapper.fromEntities(repository.getDoctorsSpecialitiesEntitiesByDoctorId(doctorId));
    }

}
