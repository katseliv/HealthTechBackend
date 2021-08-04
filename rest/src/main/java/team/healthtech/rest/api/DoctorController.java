package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.DoctorService;
import team.healthtech.service.model.DoctorDto;
import team.healthtech.service.model.create_dto.DoctorCreateDto;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;

    @Autowired
    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping
    public DoctorDto createDoctor(
        @RequestBody DoctorCreateDto doctorDto
    ) {
        return service.createDoctor(doctorDto);
    }

    @GetMapping
    public List<DoctorDto> getAllDoctors() {
        return service.getAllDoctors();
    }

    @PutMapping("/{doctorId}")
    public void updateDoctor(
        @RequestBody DoctorDto doctorDto,
        @PathVariable int doctorId
    ) {
        service.updateDoctor(doctorDto, doctorId);
    }

    @GetMapping("/{doctorId}")
    public DoctorDto findDoctor(
        @PathVariable int doctorId
    ){
        return service.getDoctorById(doctorId);
    }

    @DeleteMapping("/{doctorId}")
    public void deleteDoctor(
        @PathVariable int doctorId
    ){
        service.deleteDoctorById(doctorId);
    }

}
