package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import team.healthtech.db.entity.AdminEntity;
import team.healthtech.service.model.AdminDto;
import team.healthtech.service.model.create_dto.AdminCreateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminDto fromEntity(AdminEntity entity);

    AdminEntity toEntity(AdminDto dto);

    AdminEntity toEntity(AdminCreateDto dto);

    List<AdminDto> fromEntities(Iterable<AdminEntity> entities);

    @Mapping(target = "id", ignore = true)
    void merge(AdminDto dto, @MappingTarget AdminEntity entity);

}
