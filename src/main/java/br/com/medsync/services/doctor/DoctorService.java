package br.com.medsync.services.doctor;

import br.com.medsync.dto.doctor.DoctorRequestDTO;
import br.com.medsync.dto.doctor.DoctorResponseDTO;
import br.com.medsync.models.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    DoctorResponseDTO registerDoctor(DoctorRequestDTO request);
    List<Doctor> findAllDoctors();
    List<Doctor> findDoctorByName(String name);
    Optional<Doctor> findDoctorByCrm(String crm);
    Optional<Doctor> findDoctorByCpf(String cpf);
    Optional<Doctor> findDoctorByEmail(String email);
    DoctorResponseDTO updateDoctorById(DoctorRequestDTO request, String id);
    void deleteDoctorById(String id);

}
