package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.db.entity.DiseaseEntity;
import team.healthtech.service.model.AppointmentCreateDto;
import team.healthtech.service.model.DiseaseCreateDto;

@Mapper(componentModel = "spring")
public interface DiseaseCreateMapper {
    DiseaseCreateDto fromEntity(DiseaseEntity entity);

    DiseaseEntity toEntity(DiseaseCreateDto createDto);
}
