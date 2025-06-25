package br.com.medsync.repositories;

import br.com.medsync.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, String> {

    @Query("SELECT d FROM Doctor d WHERE d.cpf = :cpf")
    Optional<Doctor> findDoctorByCpf(@Param("cpf") String cpf);

    @Query("SELECT d FROM Doctor d WHERE d.crm = :crm")
    Optional<Doctor> findDoctorByCrm(@Param("crm") String crm);

    @Query("SELECT d FROM Doctor d WHERE d.email = :email")
    Optional<Doctor> findDoctorByEmail(@Param("email") String email);

    @Query("SELECT u FROM user u WHERE u.name LIKE %:name% AND LOWER(u.name) = LOWER(:name)")
    List<Doctor> findDoctorByNameAndIgnoreCase(@Param("name") String name);
}
