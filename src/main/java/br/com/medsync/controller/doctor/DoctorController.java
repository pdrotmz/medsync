package br.com.medsync.controller.doctor;

import br.com.medsync.dto.doctor.DoctorRequestDTO;
import br.com.medsync.dto.doctor.DoctorResponseDTO;
import br.com.medsync.services.doctor.DoctorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // TODO: Adicionar outras implementações
}
