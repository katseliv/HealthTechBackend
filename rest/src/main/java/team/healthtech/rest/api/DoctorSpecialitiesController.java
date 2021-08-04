package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping
    public List<DoctorSpecialitiesDto> getAllSpecialitiesFromDoctor(@PathVariable int doctorId) {
        return service.getAllSpecialitiesByDoctorId(doctorId);
    }

}
