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
    DiseaseEntity toEntity(DiseaseCreateDto createDto);

    DiseaseEntity toEntity(DiseaseDto createDto);

    DiseaseEntity toEntity(DiseaseUpdateDto createDto);

    List<DiseaseDto> fromEntities(Iterable<DiseaseEntity> entities);

    void merge(DiseaseUpdateDto dto, @MappingTarget DiseaseEntity entity);

}
