package team.healthtech.service.logic;

import team.healthtech.service.model.AdminDto;
import team.healthtech.service.model.create_dto.AdminCreateDto;

import javax.validation.Valid;
import java.util.List;

public interface AdminService {

    AdminDto createAdmin(@Valid AdminCreateDto adminDto);

    void updateAdmin(AdminCreateDto adminDto, int adminId);

    AdminDto getAdminById(int adminId);

    void deleteAdminById(int adminId);

    List<AdminDto> getAllAdmins();

}
