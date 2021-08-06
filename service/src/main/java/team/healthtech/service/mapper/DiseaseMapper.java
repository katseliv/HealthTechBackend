package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import team.healthtech.db.entity.DiseaseEntity;
import team.healthtech.service.model.DiseaseDto;
import team.healthtech.service.model.create_dto.DiseaseCreateDto;
import team.healthtech.service.model.update_dto.DiseaseUpdateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiseaseMapper {

    @Mapping(target = "patientId", source = "patient.id")
    DiseaseDto fromEntity(DiseaseEntity entity);

    @Mapping(target = "patient.id", source = "patientId")
    @Mapping(target = "endDate", ignore = true)
    DiseaseEntity toEntity(DiseaseCreateDto createDto);

    @Mapping(target = "patient", ignore = true)
    DiseaseEntity toEntity(DiseaseDto createDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "startDate", ignore = true)
    @Mapping(target = "patient", ignore = true)
    DiseaseEntity toEntity(DiseaseUpdateDto createDto);

    List<DiseaseDto> fromEntities(Iterable<DiseaseEntity> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "startDate", ignore = true)
    @Mapping(target = "patient", ignore = true)
    void merge(DiseaseUpdateDto dto, @MappingTarget DiseaseEntity entity);
}
