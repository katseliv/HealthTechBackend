package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import team.healthtech.db.entity.AllergyEntity;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.service.model.AllergyDto;
import team.healthtech.service.model.AppointmentDto;

@Mapper(componentModel = "spring")
public interface AllergyMapper {
    AllergyDto fromEntity(AllergyEntity entity);

    AllergyEntity toEntity(AllergyDto dto);
}
