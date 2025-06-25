package br.com.medsync.services.doctor;

import br.com.medsync.dto.doctor.DoctorRequestDTO;
import br.com.medsync.dto.doctor.DoctorResponseDTO;
import br.com.medsync.models.Doctor;
import br.com.medsync.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // TODO: Adicionar outras implementações
}
