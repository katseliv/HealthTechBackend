package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.service.model.PatientDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDto fromEntity(PatientEntity entity);

    PatientEntity toEntity(PatientDto dto);

    List<PatientDto> fromEntities(Iterable<PatientEntity> entities);

}
