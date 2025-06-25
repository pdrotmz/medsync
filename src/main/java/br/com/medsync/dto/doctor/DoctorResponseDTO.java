package br.com.medsync.dto.doctor;

import java.time.LocalDate;

public record DoctorResponseDTO(
        String id,
        String crm,
        String cpf,
        LocalDate birthDate,
        String username,
        String name,
        String email,
        String password
) {
}
