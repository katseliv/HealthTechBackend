package team.healthtech.service.logic;

import team.healthtech.service.model.DoctorSpecialitiesDto;

import java.util.List;

public interface DoctorSpecialitiesService {

    List<DoctorSpecialitiesDto> getAllSpecialitiesByDoctorId(Integer doctorId);

}
