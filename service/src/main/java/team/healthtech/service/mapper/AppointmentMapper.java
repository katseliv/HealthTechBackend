package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.db.entity.TimeRecordEntity;
import team.healthtech.service.model.AppointmentCreateDto;
import team.healthtech.service.model.AppointmentDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentDto fromEntity(AppointmentEntity entity);

    AppointmentEntity toEntity(AppointmentDto dto);

//    @Mapping(target = "patient.id", source = "patientId")
//    @Mapping(target = "timeRecord", source = "timeRecordEntity")
//    @Mapping(target = "taken", constant = "false")
//    AppointmentEntity toEntity(AppointmentCreateDto appointmentCreateDto, TimeRecordEntity timeRecordEntity, Integer patientId);

    @Mapping(target = "patient.id", source = "patientId")
    @Mapping(target = "timeRecord.doctor.id", source = "appointmentCreateDto.doctorId")
    AppointmentEntity toEntity(AppointmentCreateDto appointmentCreateDto, Integer patientId);

    List<AppointmentDto> fromEntities(Iterable<AppointmentEntity> entities);

}
