package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
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

    @Secured("ROLE_PATIENT")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public CommentDto createComment(
        @RequestBody CommentCreateDto commentCreateDto,
        @PathVariable int doctorId
    ){
        return service.createComment(commentCreateDto, doctorId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CommentDto> getAllCommentsOfDoctor(@PathVariable int doctorId){
        return service.getAllCommentsByDoctorId(doctorId);
    }

}
