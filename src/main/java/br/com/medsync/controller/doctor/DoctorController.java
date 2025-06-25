package br.com.medsync.controller.doctor;

import br.com.medsync.dto.doctor.DoctorRequestDTO;
import br.com.medsync.dto.doctor.DoctorResponseDTO;
import br.com.medsync.models.Doctor;
import br.com.medsync.services.doctor.DoctorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    @PostMapping("/register/doctor")
    public ResponseEntity<DoctorResponseDTO> registerDoctor(@RequestBody @Valid DoctorRequestDTO request) {
        DoctorResponseDTO response = doctorService.registerDoctor(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/all-doctors")
    public ResponseEntity<List<Doctor>> findAllDoctors() {
        List<Doctor> doctors = doctorService.findAllDoctors();
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }

    @GetMapping("/search-by/name/{name}")
    public ResponseEntity<List<Doctor>> findDoctorsByName(@PathVariable String name) {
        List<Doctor> doctors = doctorService.findDoctorByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }

    @GetMapping("/search-by/crm/{crm}")
    public ResponseEntity<Doctor> findDoctorByCrm(@PathVariable String crm) {
        Optional<Doctor> doctorCrm = doctorService.findDoctorByCrm(crm);
        return doctorCrm
                .map(doctor -> ResponseEntity.ok(doctor))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search-by/cpf/{cpf}")
    public ResponseEntity<Doctor> findDoctorByCpf(@PathVariable String cpf) {
        Optional<Doctor> doctorCpf = doctorService.findDoctorByCpf(cpf);
        return doctorCpf
                .map(doctor -> ResponseEntity.ok(doctor))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search-by/email/{email}")
    public ResponseEntity<Doctor> findDoctorByEmail(@PathVariable String email) {
        Optional<Doctor> doctorEmail = doctorService.findDoctorByEmail(email);
        return doctorEmail
                .map(doctor -> ResponseEntity.ok(doctor))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update-by/id/{id}")
    public ResponseEntity<DoctorResponseDTO> updateDoctorById(@RequestBody @Valid DoctorRequestDTO request,
                                                              @PathVariable String id) {
        DoctorResponseDTO response = doctorService.updateDoctorById(request, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/delete-by/id/{id}")
    public ResponseEntity<Void> deleteDoctorById(@PathVariable String id) {
        doctorService.deleteDoctorById(id);
        return ResponseEntity.noContent().build();
    }
}
