package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import team.healthtech.db.entity.TimeRecordsEntity;
import team.healthtech.service.model.TimeRecordsDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimeRecordsMapper {

    TimeRecordsDto fromEntity(TimeRecordsEntity entity);

    TimeRecordsEntity toEntity(TimeRecordsDto dto);

    List<TimeRecordsDto> fromEntities(Iterable<TimeRecordsEntity> entities);

}
