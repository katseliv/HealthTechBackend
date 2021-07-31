package team.healthtech.service.logic.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import team.healthtech.db.repository.CommentRepository;
import team.healthtech.service.logic.CommentService;
import team.healthtech.service.mapper.CommentMapper;
import team.healthtech.service.model.CommentDto;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        return Optional.of(commentDto)
            .map(commentMapper::toEntity)
            .map(commentRepository::save)
            .map(commentMapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public void deleteComment(CommentDto commentDto) {
        // realization
    }
}
