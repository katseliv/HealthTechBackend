package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import team.healthtech.db.entity.DoctorsSpecialitiesEntity;
import team.healthtech.service.model.DoctorSpecialitiesDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorSpecialitiesMapper {

    @Mapping(target = "specialityId", source = "id.specialityId")
    DoctorSpecialitiesDto fromEntity(DoctorsSpecialitiesEntity entity);

    @Mapping(target = "id.doctorId", source = "doctorId")
    @Mapping(target = "id.specialityId", source = "dto.specialityId")
    DoctorsSpecialitiesEntity toEntity(DoctorSpecialitiesDto dto, Integer doctorId);

    List<DoctorSpecialitiesDto> fromEntities(Iterable<DoctorsSpecialitiesEntity> entities);

}
