package br.com.medsync.dto.patient;

import java.time.LocalDate;

public record PatientResponseDTO(
        String id,
        String cpf,
        String username,
        String name,
        LocalDate birthDate,
        String email,
        String password
) {
}
