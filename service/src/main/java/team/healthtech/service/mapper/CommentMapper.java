package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import team.healthtech.db.entity.CommentEntity;
import team.healthtech.service.model.CommentDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDto fromEntity(CommentEntity entity);

    CommentEntity toEntity(CommentDto dto);

    List<CommentDto> fromEntities(Iterable<CommentEntity> entities);

}
