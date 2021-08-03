package team.healthtech.service.logic;

import team.healthtech.service.model.CommentCreateDto;
import team.healthtech.service.model.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(CommentCreateDto commentCreateDto, Integer doctorId);

    List<CommentDto> getAllCommentsByDoctorId(Integer doctorId);

}
