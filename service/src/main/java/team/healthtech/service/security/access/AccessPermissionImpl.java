package team.healthtech.service.security.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.healthtech.db.repository.AdminRepository;
import team.healthtech.db.repository.DoctorRepository;
import team.healthtech.db.repository.PatientRepository;

@Component("UserAccess")
public final class AccessPermissionImpl implements AccessPermission {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public AccessPermissionImpl(
        PatientRepository patientRepository,
        DoctorRepository doctorRepository,
        AdminRepository adminRepository
    ) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public boolean hasAccessToAdminController(Integer userId) {
        return adminRepository.existsById(userId);
    }

    @Override
    public boolean hasAccessToDoctorController(Integer userId) {
        return adminRepository.existsById(userId) ||
              doctorRepository.existsById(userId);
    }

    @Override
    public boolean hasAccessToPatientController(Integer userId) {
        return adminRepository.existsById(userId) ||
              doctorRepository.existsById(userId) ||
             patientRepository.existsById(userId);
    }

    @Override
    public boolean hasAccessToDiseases(Integer userId) {
        return adminRepository.existsById(userId) ||
              doctorRepository.existsById(userId);
    }

    @Override
    public boolean hasAccessToAllergies(Integer userId) {
        return adminRepository.existsById(userId) ||
              doctorRepository.existsById(userId);
    }
}
