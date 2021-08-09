package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import team.healthtech.db.entity.CommentEntity;
import team.healthtech.service.model.create_dto.CommentCreateDto;
import team.healthtech.service.model.CommentDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "doctorId", source = "doctor.id")
    @Mapping(target = "patientId", source = "patient.id")
    CommentDto fromEntity(CommentEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "doctor.id", source = "doctorId")
    @Mapping(target = "patient.id", source = "patientId")
    CommentEntity toEntity(CommentDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "doctor.id", source = "doctorId")
    @Mapping(target = "patient.id", source = "commentCreateDto.patientId")
    CommentEntity toEntity(CommentCreateDto commentCreateDto, Integer doctorId);

    List<CommentDto> fromEntities(Iterable<CommentEntity> entities);

}
