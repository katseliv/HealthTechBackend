package team.healthtech.service.logic;

import team.healthtech.service.model.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto);

    void deleteComment(CommentDto commentDto);
}
