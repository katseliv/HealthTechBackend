package team.healthtech.service.logic.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import team.healthtech.db.repository.CommentRepository;
import team.healthtech.db.repository.DoctorRepository;
import team.healthtech.service.logic.CommentService;
import team.healthtech.service.mapper.CommentMapper;
import team.healthtech.service.mapper.DoctorMapper;
import team.healthtech.service.model.CommentDto;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(
        DoctorRepository doctorRepository,
        DoctorMapper doctorMapper,
        CommentRepository commentRepository,
        CommentMapper commentMapper
    ) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer doctorId) {
        commentDto.setDoctor(
            doctorMapper.fromEntity(
                doctorRepository.findById(doctorId).orElseThrow()
            )
        );

        return Optional.of(commentDto)
            .map(commentMapper::toEntity)
            .map(commentRepository::save)
            .map(commentMapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public List<CommentDto> getAllCommentsByDoctorId(Integer doctorId) {
        return commentMapper.fromEntities(commentRepository.getAllByDoctorId(doctorId));
    }

}
