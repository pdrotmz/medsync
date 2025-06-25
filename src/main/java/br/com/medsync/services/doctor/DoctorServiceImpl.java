package br.com.medsync.services.doctor;

import br.com.medsync.dto.doctor.DoctorRequestDTO;
import br.com.medsync.dto.doctor.DoctorResponseDTO;
import br.com.medsync.models.Doctor;
import br.com.medsync.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public DoctorResponseDTO registerDoctor(DoctorRequestDTO request) {

        Doctor doctor = new Doctor();
        doctor.setCrm(request.crm());
        doctor.setCpf(request.cpf());
        doctor.setBirthDate(request.birthDate());
        doctor.setName(request.name());
        doctor.setUsername(request.username());
        doctor.setEmail(request.email());
        doctor.setPassword(request.password());

        doctorRepository.save(doctor);

        return new DoctorResponseDTO(
                doctor.getId(),
                request.crm(),
                request.cpf(),
                request.birthDate(),
                request.username(),
                request.name(),
                request.email(),
                request.password()
        );
    }

    @Override
    public List<Doctor> findAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors;
    }

    @Override
    public List<Doctor> findDoctorByName(String name) {
        List<Doctor> doctors = doctorRepository.findDoctorByNameAndIgnoreCase(name);
        return doctors;
    }

    @Override
    public Optional<Doctor> findDoctorByCrm(String crm) {
        Optional<Doctor> optionalCrm = doctorRepository.findDoctorByCrm(crm);

        if(optionalCrm.isEmpty() || optionalCrm == null) {
            throw new RuntimeException("Erro ao procurar doutor com esse CRM");
        }
        return optionalCrm;
    }

    @Override
    public Optional<Doctor> findDoctorByCpf(String cpf) {
        Optional<Doctor> optionalCpf = doctorRepository.findDoctorByCpf(cpf);

        if(optionalCpf.isEmpty() || optionalCpf == null) {
            throw new RuntimeException("Erro ao procurar doutor com esse CPF");
        }
        return optionalCpf;
    }

    @Override
    public Optional<Doctor> findDoctorByEmail(String email) {
        Optional<Doctor> optionalEmail = doctorRepository.findDoctorByEmail(email);

        if(optionalEmail.isEmpty() || optionalEmail == null) {
            throw new RuntimeException("Erro ao procurar doutor com esse email");
        }
        return optionalEmail;
    }

    @Override
    public DoctorResponseDTO updateDoctorById(DoctorRequestDTO request, String id) {
        Doctor existing = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro ao procurar doutor com esse id"));

        existing.setCrm(request.crm());
        existing.setCpf(request.cpf());
        existing.setBirthDate(request.birthDate());
        existing.setUsername(request.username());
        existing.setName(request.name());
        existing.setEmail(request.email());

        doctorRepository.save(existing);

        return new DoctorResponseDTO(
                existing.getId(),
                request.crm(),
                request.cpf(),
                request.birthDate(),
                request.username(),
                request.name(),
                request.email(),
                request.password()
        );
    }

    @Override
    public void deleteDoctorById(String id) {
        doctorRepository.deleteById(id);
    }
}
