package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.model.create_dto.AppointmentCreateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(target = "patientId", source = "patient.id")
    @Mapping(target = "doctorId", source = "timeRecord.doctor.id")
    AppointmentDto fromEntity(AppointmentEntity entity);

    @Mapping(target = "patient.id", source = "patientId")
    @Mapping(target = "timeRecord.doctor.id", source = "doctorId")
    AppointmentEntity toEntity(AppointmentDto dto);

    @Mapping(target = "patient.id", source = "patientId")
    @Mapping(target = "timeRecord.doctor.id", source = "appointmentCreateDto.doctorId")
    AppointmentEntity toEntity(AppointmentCreateDto appointmentCreateDto, Integer patientId);

    List<AppointmentDto> fromEntities(Iterable<AppointmentEntity> entities);

}
