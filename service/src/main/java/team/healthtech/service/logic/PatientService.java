package team.healthtech.service.logic;

import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.model.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto createPatient(PatientDto patientDto);

    PatientDto updatePatient(PatientDto patientDto, int patientId);

    PatientDto getPatientById(int patientId);

    void deletePatientById(int patientId);

    List<PatientDto> getAllPatients();

    List<AppointmentDto> getAppointmentsOfPatientById(int patientId);

}
