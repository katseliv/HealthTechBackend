package team.healthtech.service.logic.impl;

import org.springframework.stereotype.Service;
import team.healthtech.service.logic.DoctorSpecialitiesService;
import team.healthtech.service.model.DoctorSpecialitiesDto;

import java.util.List;

@Service
public class DoctorSpecialitiesServiceImpl implements DoctorSpecialitiesService {

    @Override
    public List<DoctorSpecialitiesDto> getAllSpecialitiesByDoctorId(Integer doctorId) {
        return null;
    }

}
