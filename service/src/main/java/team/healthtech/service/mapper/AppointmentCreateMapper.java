package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.service.model.AppointmentCreateDto;

@Mapper(componentModel = "spring")
public interface AppointmentCreateMapper {

    AppointmentCreateDto fromEntity(AppointmentEntity entity);

    AppointmentEntity toEntity(AppointmentCreateDto dto);
}
