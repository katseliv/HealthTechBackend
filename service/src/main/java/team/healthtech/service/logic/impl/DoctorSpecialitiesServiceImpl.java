package team.healthtech.service.logic.impl;

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
        Integer specialityId = dto.getSpecialityId();
        Date receiveDate = dto.getReceiveDate();

        DoctorsSpecialitiesEntity entity = new DoctorsSpecialitiesEntity();
        DoctorSpecialityId id = new DoctorSpecialityId();
        id.setDoctorId(doctorId);
        id.setSpecialityId(specialityId);
        entity.setId(id);
        entity.setReceiveDate(receiveDate);

//        mapper.toEntity(dto, doctorId)
        repository.save(entity);
    }

    @Override
    public List<DoctorSpecialitiesDto> getAllSpecialitiesByDoctorId(Integer doctorId) {
        return mapper.fromEntities(repository.getDoctorsSpecialitiesEntitiesByDoctorId(doctorId));
    }

}
