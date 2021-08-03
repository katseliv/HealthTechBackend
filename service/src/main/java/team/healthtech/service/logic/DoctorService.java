package team.healthtech.service.logic;

import team.healthtech.service.model.DoctorDto;
import team.healthtech.service.model.create_dto.DoctorCreateDto;

import javax.validation.Valid;
import java.util.List;

public interface DoctorService {
    DoctorDto createDoctor(@Valid DoctorCreateDto doctorDto);

    void updateDoctor(DoctorDto doctorDto, int doctorId);

    DoctorDto getDoctorById(int doctorId);

    void deleteDoctorById(int doctorId);

    List<DoctorDto> getAllDoctors();
}
