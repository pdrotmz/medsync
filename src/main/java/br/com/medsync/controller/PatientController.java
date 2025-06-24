package br.com.medsync.controller;

import br.com.medsync.dto.patient.PatientRequestDTO;
import br.com.medsync.dto.patient.PatientResponseDTO;
import br.com.medsync.dto.patient.RequestPasswordDTO;
import br.com.medsync.dto.patient.ResponsePasswordDTO;
import br.com.medsync.models.Patient;
import br.com.medsync.services.patient.PatientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping("/register")
    public ResponseEntity<PatientResponseDTO> registerPatient(@RequestBody @Valid PatientRequestDTO request) {
        PatientResponseDTO response = patientService.registerPatient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/all-patients")
    public ResponseEntity<List<Patient>> findAllPatients() {
        List<Patient> patients = patientService.findAllPatients();
        return ResponseEntity.status(HttpStatus.OK).body(patients);
    }

    @GetMapping("/search-by/cpf/{cpf}")
    public ResponseEntity<Patient> findPatientByCpf(@PathVariable String cpf) {
        Optional<Patient> optionalCpf = patientService.findPatientByCpf(cpf);
        return optionalCpf
                .map(patient -> ResponseEntity.ok(patient))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search-by/birthDate/{birthDate}")
    public ResponseEntity<List<Patient>> findPatientByBirthDate(@PathVariable LocalDate birthDate) {
        List<Patient> patients = patientService.findByBirthDate(birthDate);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(patients);
    }

    @GetMapping("/search-by/email/{email}")
    public ResponseEntity<Patient> findPatientByEmail(@PathVariable String email) {
        Optional<Patient> optionalEmail = patientService.findPatientByEmail(email);
        return optionalEmail
                .map(patient -> ResponseEntity.ok(patient))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update-by/id/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatientById(@RequestBody @Valid Patient patient,
                                                                @PathVariable String id) {
        PatientResponseDTO response = patientService.updatePatientById(patient, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @PutMapping("/update-password/email/{email}")
    public ResponseEntity<ResponsePasswordDTO> updatePatientPassword(@RequestBody @Valid RequestPasswordDTO request,
                                                                    @PathVariable String email) {

        ResponsePasswordDTO response = patientService.updatedPatientPassword(request, email);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/delete-by/id/{id}")
    public ResponseEntity<Void> deletePatientById(@PathVariable String id) {
        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }
}
