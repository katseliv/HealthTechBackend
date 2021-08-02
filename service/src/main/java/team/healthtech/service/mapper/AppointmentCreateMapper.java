package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.db.entity.TimeRecordEntity;
import team.healthtech.service.model.AppointmentCreateDto;
import team.healthtech.service.model.AppointmentDto;

@Mapper(componentModel = "spring")
public interface AppointmentCreateMapper {

    AppointmentCreateDto fromAppointmentDto(AppointmentDto appointmentDto);

    AppointmentDto toAppointmentDto(AppointmentCreateDto appointmentCreateDto);

//    @Mapping(target = "patient.id", source = "createDto.patientId")
//    @Mapping(target = "timeRecord", source = "e")
//    @Mapping(target = "taken", constant = "false")
//    AppointmentEntity toEntity(AppointmentCreateDto createDto, TimeRecordEntity e);
}
