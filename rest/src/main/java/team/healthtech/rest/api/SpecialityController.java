package team.healthtech.rest.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.SpecialityService;
import team.healthtech.service.model.SpecialityDto;

import java.util.List;

@RestController
@RequestMapping("/specialities")
public class SpecialityController {

    private final SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createSpeciality(
        @RequestBody SpecialityDto specialityDto
    ) {
        specialityService.createSpeciality(specialityDto);
    }

    @GetMapping
    public List<SpecialityDto> getAllSpecialities() {
        return specialityService.getAllSpecialities();
    }
}
