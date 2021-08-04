package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.service.model.PatientDto;
import team.healthtech.service.model.create_dto.PatientCreateDto;

import java.util.List;

@Mapper(componentModel = "spring", uses = AppointmentMapper.class)
public interface PatientMapper {

    PatientDto fromEntity(PatientEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "phoneNumber", ignore = true)
    void merge(PatientDto dto, @MappingTarget PatientEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    //@Mapping(target = "role", ignore = true)
    void toEntity(PatientDto dto, @MappingTarget PatientEntity original);

    @Mapping(target = "id", ignore = true)
    PatientEntity toEntity(PatientCreateDto dto);

    @Mapping(target = "id", ignore = true)
    PatientEntity toEntity(PatientDto dto);

    List<PatientDto> fromEntities(Iterable<PatientEntity> entities);

}
