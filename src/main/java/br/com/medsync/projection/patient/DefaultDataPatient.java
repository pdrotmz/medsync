package br.com.medsync.projection.patient;

import java.time.LocalDate;

public interface DefaultDataPatient {
    String cpf();
    String name();
    LocalDate birthDate();
}
