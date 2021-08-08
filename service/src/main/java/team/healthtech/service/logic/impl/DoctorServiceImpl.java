package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import team.healthtech.common.Role;
import team.healthtech.db.entity.CommentEntity;
import team.healthtech.db.entity.DoctorEntity;
import team.healthtech.db.repository.CommentRepository;
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
    private final CommentRepository commentRepository;
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorServiceImpl(
        ObjectProvider<Profile> profileProvider,
        HealthtechPasswordEncoder passwordEncoder,
        CommentRepository commentRepository,
        DoctorRepository doctorRepository,
        DoctorMapper doctorMapper
    ) {
        this.profileProvider = profileProvider;
        this.passwordEncoder = passwordEncoder;
        this.commentRepository = commentRepository;
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public DoctorDto createDoctor(@Valid DoctorCreateDto doctorDto) {
        String encodePassword = passwordEncoder.encode(doctorDto.getPassword());
        doctorDto.setPassword(encodePassword);
        doctorDto.setRole(Role.DOCTOR);

        return Optional.of(doctorDto)
            .map(doctorMapper::toEntity)
            .map(doctorRepository::save)
            .map(doctorMapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public void updateDoctor(DoctorDto doctorDto, int doctorId) {
        DoctorEntity entity = doctorRepository.findById(doctorId).orElseThrow();
        doctorMapper.merge(doctorDto, entity);
        doctorRepository.save(doctorMapper.toEntity(doctorDto));
    }

    @Override
    public DoctorDto getDoctorById(int doctorId) {
        DoctorDto doctorDto = doctorMapper
            .fromEntity(
                doctorRepository
                .findById(doctorId)
                .orElseThrow()
            );
        doctorDto.setRating(getRatingOfDoctor(doctorId));

        return doctorDto;
    }

    @Override
    public void deleteDoctorById(int doctorId) {
        doctorRepository.deleteById(doctorId);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        return doctorMapper.fromEntities(doctorRepository.findAll());
    }

    private Double getRatingOfDoctor(Integer doctorId) {
        List<CommentEntity> comments = commentRepository.getAllByDoctorId(doctorId);
        Double ratingSum = .0;
        for(var comment: comments) {
            ratingSum += comment.getMark();
        }
        return ratingSum / comments.size();
    }
}
