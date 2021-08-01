package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import team.healthtech.db.entity.DiseaseEntity;
import team.healthtech.db.entity.TimeRecordEntity;
import team.healthtech.service.model.DiseaseDto;
import team.healthtech.service.model.TimeRecordDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimeRecordMapper {

    TimeRecordDto fromEntity(TimeRecordEntity entity);

    TimeRecordEntity toEntity(TimeRecordDto dto);

    List<TimeRecordDto> fromEntities(Iterable<TimeRecordEntity> entities);

    @Mapping(target = "doctorId", ignore = true)
    void merge(TimeRecordDto dto, @MappingTarget TimeRecordEntity entity);
}