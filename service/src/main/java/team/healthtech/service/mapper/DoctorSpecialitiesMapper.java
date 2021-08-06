package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import team.healthtech.db.entity.DoctorsSpecialitiesEntity;
import team.healthtech.service.model.DoctorSpecialitiesDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorSpecialitiesMapper {

    @Mapping(target = "name", source = "speciality.name")
    DoctorSpecialitiesDto fromEntity(DoctorsSpecialitiesEntity entity);

    @Mapping(target = "speciality.name", source = "name")
    DoctorsSpecialitiesEntity toEntity(DoctorSpecialitiesDto dto);

    List<DoctorSpecialitiesDto> fromEntities(Iterable<DoctorsSpecialitiesEntity> entities);

}
