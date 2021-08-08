package team.healthtech.service.security.access;

public interface AccessPermission {

    boolean hasAccessToAdminController(Integer userId);

    boolean hasAccessToDoctorController(Integer userId);

    boolean hasAccessToPatientController(Integer userId);

    boolean hasAccessToDiseases(Integer userId);

    boolean hasAccessToAllergies(Integer userId);

}
