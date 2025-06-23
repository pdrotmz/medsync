package br.com.medsync.controller;

import br.com.medsync.dto.PatientRequestDTO;
import br.com.medsync.dto.PatientResponseDTO;
import br.com.medsync.models.User;
import br.com.medsync.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("register")
    public ResponseEntity<PatientResponseDTO> register(@RequestBody @Valid PatientRequestDTO request) {
        PatientResponseDTO response = service.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // TODO: Implementar os outros endpoints
}
