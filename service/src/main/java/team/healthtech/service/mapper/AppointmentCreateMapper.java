package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.service.model.AppointmentCreateDto;
import team.healthtech.service.model.AppointmentDto;

@Mapper(componentModel = "spring")
public interface AppointmentCreateMapper {

    AppointmentCreateDto fromAppointmentDto(AppointmentDto appointmentDto);

    AppointmentDto toAppointmentDto(AppointmentCreateDto appointmentCreateDto);

}
