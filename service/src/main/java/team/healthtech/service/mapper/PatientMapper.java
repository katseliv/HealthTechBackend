package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.service.model.PatientDto;

import java.util.List;

@Mapper(componentModel = "spring", uses = AppointmentMapper.class)
public interface PatientMapper {

    PatientDto fromEntity(PatientEntity entity);

    PatientEntity toEntity(PatientDto dto);

    List<PatientDto> fromEntities(Iterable<PatientEntity> entities);

    @Mapping(target="id", ignore = true)

    void merge(PatientDto dto, @MappingTarget PatientEntity entity);
}
