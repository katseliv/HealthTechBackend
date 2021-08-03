package team.healthtech.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.repository.DoctorRepository;
import team.healthtech.service.logic.DoctorService;
import team.healthtech.service.mapper.DoctorMapper;
import team.healthtech.service.model.DoctorDto;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorServiceImpl(
        DoctorRepository doctorRepository,
        DoctorMapper doctorMapper
    ) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        return Optional.of(doctorDto)
            .map(doctorMapper::toEntity)
            .map(doctorRepository::save)
            .map(doctorMapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public void updateDoctor(DoctorDto doctorDto, int doctorId) {
        doctorMapper.merge(doctorDto, doctorRepository.findById(doctorId).orElseThrow());
        doctorRepository.save(doctorMapper.toEntity(doctorDto));
    }

    @Override
    public DoctorDto getDoctorById(int doctorId) {
        return doctorRepository.findById(doctorId)
            .map(doctorMapper::fromEntity)
            .orElse(null);
    }

    @Override
    public void deleteDoctorById(int doctorId) {
        doctorRepository.deleteById(doctorId);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        return doctorMapper.fromEntities(doctorRepository.findAll());
    }
}
