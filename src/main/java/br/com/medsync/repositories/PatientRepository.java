package br.com.medsync.repositories;

import br.com.medsync.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, String> {

    @Query("SELECT p FROM Patient p WHERE p.cpf = :cpf")
    Optional<Patient> findPatientByCpf(@Param("cpf") String cpf);

    @Query("SELECT p FROM Patient p WHERE p.email =: email")
    Optional<Patient> findPatientByEmail(@Param("email") String email);

    @Query("SELECT p FROM Patient p WHERE p.birthDate =: birthDate")
    List<Patient> findPatientByBirthDate(@Param("birthDate") LocalDate birthDate);
}
