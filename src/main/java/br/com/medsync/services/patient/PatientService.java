package br.com.medsync.services.patient;

import br.com.medsync.dto.PatientRequestDTO;
import br.com.medsync.dto.PatientResponseDTO;
import br.com.medsync.models.Patient;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    PatientResponseDTO registerPatient(PatientRequestDTO request);
    List<Patient> findAllPatients();
    List<Patient> findByBirthDate(LocalDate birthDate);
    Optional<Patient> findPatientByCpf(String cpf);
    Optional<Patient> findPatientByEmail(String email);
    void updatePatientById(Patient patient, String id);
    void deletePatientById(String id);
}
