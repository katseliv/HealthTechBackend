package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import team.healthtech.db.entity.TimeRecordEntity;
import team.healthtech.service.model.TimeRecordDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimeRecordMapper {

    TimeRecordDto fromEntity(TimeRecordEntity entity);

    TimeRecordEntity toEntity(TimeRecordDto dto);

    List<TimeRecordDto> fromEntities(Iterable<TimeRecordEntity> entities);

}
