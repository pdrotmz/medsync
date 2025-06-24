package br.com.medsync.controller;

import br.com.medsync.dto.PatientRequestDTO;
import br.com.medsync.dto.PatientResponseDTO;
import br.com.medsync.models.Patient;
import br.com.medsync.services.patient.PatientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // TODO: Implementar os outros endpoints
}
