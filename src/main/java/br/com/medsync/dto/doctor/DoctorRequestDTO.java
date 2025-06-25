package br.com.medsync.dto.doctor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DoctorRequestDTO(
        @NotBlank(message = "CPF é obrigatório") String cpf,
        @NotBlank(message = "CRM é obrigatório") String crm,
        @NotNull(message = "Dia do nascimento é obrigatório") LocalDate birthDate,
        @NotBlank(message = "Username é obrigatório") String username,
        @NotBlank(message = "Nome é obrigatório") String name,
        @NotBlank(message = "Email é obrigatório") String email,
        @NotBlank(message = "Senha é obrigatório") String password
) {
}
