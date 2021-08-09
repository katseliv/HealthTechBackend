package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import team.healthtech.db.entity.SpecialityEntity;
import team.healthtech.service.model.SpecialityDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecialityMapper {
    SpecialityDto fromEntity(SpecialityEntity entity);

    SpecialityEntity toEntity(SpecialityDto dto);

    List<SpecialityDto> fromEntities(Iterable<SpecialityEntity> entities);
}
