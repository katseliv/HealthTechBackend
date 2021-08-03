package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.db.entity.DiseaseEntity;
import team.healthtech.service.model.AppointmentCreateDto;
import team.healthtech.service.model.DiseaseCreateDto;
import team.healthtech.service.model.DiseaseDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiseaseMapper {

    DiseaseDto fromEntity(DiseaseEntity entity);

    @Mapping(target = "endDate", source = "createDto.endDate")
    DiseaseEntity toEntity(DiseaseCreateDto createDto);

    DiseaseEntity toEntity(DiseaseDto createDto);

    List<DiseaseDto> fromEntities(Iterable<DiseaseDto> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "startDate", ignore = true)
    void merge(DiseaseDto dto, @MappingTarget DiseaseEntity entity);
}
