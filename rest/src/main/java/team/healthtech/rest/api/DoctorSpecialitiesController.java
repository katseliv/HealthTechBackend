package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.DoctorSpecialitiesService;
import team.healthtech.service.model.DoctorSpecialitiesDto;

import java.util.List;

@RestController
@RequestMapping("/doctors/{doctorId}/specialities")
public class DoctorSpecialitiesController {

    private final DoctorSpecialitiesService service;

    @Autowired
    public DoctorSpecialitiesController(DoctorSpecialitiesService service) {
        this.service = service;
    }

    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public void addSpecialityToDoctor(@RequestBody DoctorSpecialitiesDto dto, @PathVariable int doctorId){
        service.addSpecialityByDoctorId(dto, doctorId);
    }

    @GetMapping
    public List<DoctorSpecialitiesDto> getAllSpecialitiesFromDoctor(@PathVariable int doctorId) {
        return service.getAllSpecialitiesByDoctorId(doctorId);
    }

}
