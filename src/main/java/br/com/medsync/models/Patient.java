package br.com.medsync.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity(name = "patient")
@Table(name = "tb_patient")
@Data
public class Patient extends User {

    @Column(name = "cpf", length = 11, unique = true, nullable = false)
    private String cpf;

    @Column(name = "birth_date")
    private LocalDate birthDate;
}
