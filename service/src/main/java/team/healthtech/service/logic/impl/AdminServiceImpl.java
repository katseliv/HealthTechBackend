package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import team.healthtech.common.Role;
import team.healthtech.db.entity.AdminEntity;
import team.healthtech.db.entity.DoctorEntity;
import team.healthtech.db.repository.AdminRepository;
import team.healthtech.service.logic.AdminService;
import team.healthtech.service.mapper.AdminMapper;
import team.healthtech.service.model.AdminDto;
import team.healthtech.service.model.create_dto.AdminCreateDto;
import team.healthtech.service.security.HealthtechPasswordEncoder;
import team.healthtech.service.security.Profile;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class AdminServiceImpl implements AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
    private final ObjectProvider<Profile> profileProvider;
    private final HealthtechPasswordEncoder passwordEncoder;
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    @Autowired
    public AdminServiceImpl(
        ObjectProvider<Profile> profileProvider,
        HealthtechPasswordEncoder passwordEncoder,
        AdminRepository adminRepository,
        AdminMapper adminMapper
    ) {
        this.profileProvider = profileProvider;
        this.passwordEncoder = passwordEncoder;
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    @Override
    public AdminDto createAdmin(@Valid AdminCreateDto adminDto) {
        if (profileProvider.getIfAvailable() == null) {
            logger.info("New admin create request by anonymous");
        } else {
            logger.info("New admin create request by {}", profileProvider.getIfAvailable());
        }
        String encodePassword = passwordEncoder.encode(adminDto.getPassword());
        adminDto.setPassword(encodePassword);
        adminDto.setRole(Role.ADMIN);

        return Optional.of(adminDto)
            .map(adminMapper::toEntity)
            .map(adminRepository::save)
            .map(adminMapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public void updateAdmin(AdminCreateDto adminCreateDto, int adminId) {
        AdminEntity entity = adminRepository.findById(adminId).orElseThrow();

        if (adminCreateDto.getPassword().isBlank()) {
            adminCreateDto.setPassword(entity.getPassword());
        }
        logger.info("Admin update with id {} request by {}", adminDto.getId(), profileProvider.getIfAvailable());
        adminMapper.merge(adminCreateDto, entity);
        adminRepository.save(entity);
    }

    @Override
    public AdminDto getAdminById(int adminId) {
        logger.info("Admin get with id {} request by {}", adminId, profileProvider.getIfAvailable());
        return adminRepository.findById(adminId)
            .map(adminMapper::fromEntity)
            .orElse(null);
    }

    @Override
    public void deleteAdminById(int adminId) {
        logger.info("Admin delete with id {} request by {}", adminId, profileProvider.getIfAvailable());
        adminRepository.deleteById(adminId);
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        logger.info("Admin list get request by {}", profileProvider.getIfAvailable());
        return adminMapper.fromEntities(adminRepository.findAll());
    }

}
