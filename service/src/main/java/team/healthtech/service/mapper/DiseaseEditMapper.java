package team.healthtech.service.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import team.healthtech.db.entity.DiseaseEntity;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.service.model.DiseaseCreateDto;
import team.healthtech.service.model.DiseaseEditDto;
import team.healthtech.service.model.PatientDto;

import java.util.List;

public interface DiseaseEditMapper {
    DiseaseEditDto fromEntity(DiseaseEntity entity);

    DiseaseEntity toEntity(DiseaseEditDto createDto);

    List<DiseaseEditDto> fromEntities(Iterable<DiseaseEditDto> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "patient_id", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "start_date", ignore = true)
    void merge(DiseaseEditDto dto, @MappingTarget DiseaseEntity entity);
}
