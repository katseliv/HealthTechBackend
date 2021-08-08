package team.healthtech.service.logic;

import team.healthtech.service.model.SpecialityDto;

import java.util.List;

public interface SpecialityService {

    SpecialityDto createSpeciality(SpecialityDto specialityDto);

    List<SpecialityDto> getAllSpecialities();
}
