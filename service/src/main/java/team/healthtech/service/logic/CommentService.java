package team.healthtech.service.logic;

import team.healthtech.service.model.create_dto.CommentCreateDto;
import team.healthtech.service.model.CommentDto;

import javax.validation.Valid;
import java.util.List;

public interface CommentService {

    CommentDto createComment(@Valid CommentCreateDto commentCreateDto, Integer doctorId);

    List<CommentDto> getAllCommentsByDoctorId(Integer doctorId);

}
