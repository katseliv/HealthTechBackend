package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import team.healthtech.db.entity.TimeRecordsEntity;
import team.healthtech.service.model.TimeRecordDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimeRecordMapper {

    TimeRecordDto fromEntity(TimeRecordsEntity entity);

    TimeRecordsEntity toEntity(TimeRecordDto dto);

    List<TimeRecordDto> fromEntities(Iterable<TimeRecordsEntity> entities);

}
