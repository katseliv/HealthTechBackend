package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import team.healthtech.db.entity.DoctorEntity;
import team.healthtech.service.model.DoctorDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    DoctorDto fromEntity(DoctorEntity entity);

    DoctorEntity toEntity(DoctorDto dto);

    List<DoctorDto> fromEntities(Iterable<DoctorEntity> entities);

}
