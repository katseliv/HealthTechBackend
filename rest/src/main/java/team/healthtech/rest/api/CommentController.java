package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.CommentService;
import team.healthtech.service.model.create_dto.CommentCreateDto;
import team.healthtech.service.model.CommentDto;

import java.util.List;

@RestController
@RequestMapping("/comments/{doctorId}")
public class CommentController {

    private final CommentService service;

    @Autowired
    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping
    public CommentDto createComment(
        @RequestBody CommentCreateDto commentCreateDto,
        @PathVariable int doctorId
    ){
        return service.createComment(commentCreateDto, doctorId);
    }

    @GetMapping
    public List<CommentDto> getAllCommentsOfDoctor(@PathVariable int doctorId){
        return service.getAllCommentsByDoctorId(doctorId);
    }

}
