package br.com.medsync.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tb_doctor")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Doctor extends User {

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "crm", length = 6, nullable = false, unique = true)
    private String crm;

    @Column(name = "birthDate")
    private LocalDate birthDate;
}
