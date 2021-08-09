package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.service.model.PatientDto;
import team.healthtech.service.model.create_dto.PatientCreateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDto fromEntity(PatientEntity entity);

    void merge(PatientDto dto, @MappingTarget PatientEntity entity);

    void merge(PatientCreateDto dto, @MappingTarget PatientEntity entity);

    void toEntity(PatientDto dto, @MappingTarget PatientEntity original);

    PatientEntity toEntity(PatientCreateDto dto);

    PatientEntity toEntity(PatientDto dto);

    List<PatientDto> fromEntities(Iterable<PatientEntity> entities);

}
