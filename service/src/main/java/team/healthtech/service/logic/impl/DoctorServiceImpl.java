package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import team.healthtech.db.repository.DoctorRepository;
import team.healthtech.service.logic.DoctorService;
import team.healthtech.service.mapper.DoctorMapper;
import team.healthtech.service.model.DoctorDto;
import team.healthtech.service.model.create_dto.DoctorCreateDto;
import team.healthtech.service.security.HealthtechPasswordEncoder;
import team.healthtech.service.security.Profile;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class DoctorServiceImpl implements DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);
    private final ObjectProvider<Profile> profileProvider;
    private final HealthtechPasswordEncoder passwordEncoder;
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorServiceImpl(
        ObjectProvider<Profile> profileProvider,
        HealthtechPasswordEncoder passwordEncoder, DoctorRepository doctorRepository,
        DoctorMapper doctorMapper
    ) {
        this.profileProvider = profileProvider;
        this.passwordEncoder = passwordEncoder;
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public DoctorDto createDoctor(@Valid DoctorCreateDto doctorDto) {
        String encodePassword = passwordEncoder.encode(doctorDto.getPassword());
        doctorDto.setPassword(encodePassword);

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
