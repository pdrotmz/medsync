package br.com.medsync.services.patient;

import br.com.medsync.dto.patient.PatientRequestDTO;
import br.com.medsync.dto.patient.PatientResponseDTO;
import br.com.medsync.dto.global.RequestPasswordDTO;
import br.com.medsync.dto.global.ResponsePasswordDTO;
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
    PatientResponseDTO updatePatientById(Patient patient, String id);
    ResponsePasswordDTO updatedPatientPassword(RequestPasswordDTO request, String id);
    void deletePatientById(String id);
}
