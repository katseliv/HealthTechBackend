package team.healthtech.service.logic.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import team.healthtech.db.entity.CommentEntity;
import team.healthtech.db.repository.CommentRepository;
import team.healthtech.service.logic.CommentService;
import team.healthtech.service.mapper.CommentMapper;
import team.healthtech.service.model.CommentCreateDto;
import team.healthtech.service.model.CommentDto;

import java.time.Instant;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(
        CommentRepository commentRepository,
        CommentMapper commentMapper
    ) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public CommentDto createComment(CommentCreateDto commentCreateDto, Integer doctorId) {
//        1 option
        CommentEntity commentEntity = commentMapper.toEntity(commentCreateDto, doctorId);
        Instant datetime = Instant.now();
        commentEntity.setDate(datetime);
        return
            commentMapper.fromEntity(
                commentRepository.save(commentEntity));

//        2 option
//        CommentEntity commentEntity = commentMapper.toEntity(commentCreateDto);
//        commentEntity.setDoctor(doctorRepository.findById(doctorId).orElseThrow());
//        commentEntity.setPatient(patientRepository.findById(commentCreateDto.getPatientId()).orElseThrow());
//
//        return commentMapper.fromEntity(commentRepository.save(commentEntity));
    }

    @Override
    public List<CommentDto> getAllCommentsByDoctorId(Integer doctorId) {
        return commentMapper.fromEntities(commentRepository.getAllByDoctorId(doctorId));
    }

}
