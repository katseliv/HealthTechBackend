package team.healthtech.service.logic;

import team.healthtech.service.model.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto createDoctor(DoctorDto doctorDto);

    void updateDoctor(DoctorDto doctorDto, int doctorId);

    DoctorDto getDoctorById(int doctorId);

    void deleteDoctorById(int doctorId);

    List<DoctorDto> getAllDoctors();
}
