package team.healthtech.service.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import team.healthtech.db.entity.DiseaseEntity;
import team.healthtech.service.model.DiseaseDto;

import java.util.List;

public interface DiseaseUpdateMapper {
    DiseaseDto fromEntity(DiseaseEntity entity);

    DiseaseEntity toEntity(DiseaseDto createDto);

    List<DiseaseDto> fromEntities(Iterable<DiseaseDto> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "patient_id", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "start_date", ignore = true)
    void merge(DiseaseDto dto, @MappingTarget DiseaseEntity entity);
}
