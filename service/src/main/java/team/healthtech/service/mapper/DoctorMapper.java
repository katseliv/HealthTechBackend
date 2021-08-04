package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import team.healthtech.db.entity.DoctorEntity;
import team.healthtech.service.model.DoctorDto;
import team.healthtech.service.model.create_dto.DoctorCreateDto;

import java.util.List;

@Mapper(componentModel = "spring", uses = TimeRecordMapper.class)
public interface DoctorMapper {

    DoctorDto fromEntity(DoctorEntity entity);

    DoctorEntity toEntity(DoctorDto dto);

    DoctorEntity toEntity(DoctorCreateDto dto);

    List<DoctorDto> fromEntities(Iterable<DoctorEntity> entities);

    @Mapping(target = "id", ignore = true)
    void merge(DoctorDto dto, @MappingTarget DoctorEntity entity);
}
