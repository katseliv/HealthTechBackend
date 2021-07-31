package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.service.model.AppointmentDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    AppointmentDto fromEntity(AppointmentEntity entity);

    AppointmentEntity toEntity(AppointmentDto dto);

    List<AppointmentDto> fromEntities(Iterable<AppointmentEntity> entities);

}
