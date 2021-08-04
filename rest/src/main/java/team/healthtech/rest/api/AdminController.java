package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.AdminService;
import team.healthtech.service.model.AdminDto;
import team.healthtech.service.model.create_dto.AdminCreateDto;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService service;

    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }

    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public AdminDto createAdmin(
        @RequestBody AdminCreateDto adminDto
    ) {
        return service.createAdmin(adminDto);
    }

    @GetMapping
    public List<AdminDto> getAllAdmins() {
        return service.getAllAdmins();
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{adminId}")
    public void updateAdmin(
        @RequestBody AdminDto adminDto,
        @PathVariable int adminId
    ) {
        service.updateAdmin(adminDto, adminId);
    }

    @GetMapping("/{adminId}")
    public AdminDto findAdmin(
        @PathVariable int adminId
    ){
        return service.getAdminById(adminId);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{adminId}")
    public void deleteAdmin(
        @PathVariable int adminId
    ){
        service.deleteAdminById(adminId);
    }

}
