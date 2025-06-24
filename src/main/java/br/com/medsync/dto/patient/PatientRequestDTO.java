package br.com.medsync.dto.patient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PatientRequestDTO(
        @NotBlank(message = "CPF é obrigatório") String cpf,
        @NotBlank(message = "Username é obrigatório") String username,
        @NotBlank(message = "Nome é obrigatório") String name,
        @NotNull(message = "Data de nascimento é obrigatória") LocalDate birthDate,
        @NotBlank(message = "Email é obrigatório") String email,
        @NotBlank(message = "Senha é obrigatório") String password
) {
}
