package br.com.medsync.services;

import br.com.medsync.dto.PatientRequestDTO;
import br.com.medsync.dto.PatientResponseDTO;
import br.com.medsync.models.Patient;
import br.com.medsync.models.User;
import br.com.medsync.repositories.PatientRepository;
import br.com.medsync.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;

    public PatientResponseDTO registerUser(PatientRequestDTO request) {

        Patient patient = new Patient();
        patient.setCpf(request.cpf());
        patient.setUsername(request.username());
        patient.setName(request.name());
        patient.setBirthDate(request.birthDate());
        patient.setEmail(request.email());
        patient.setPassword(request.password());

        patientRepository.save(patient);

        return new PatientResponseDTO(
                patient.getId(),
                request.cpf(),
                request.username(),
                request.name(),
                request.birthDate(),
                request.email(),
                request.password()
                );
    }

    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public List<User> findAllUserByName(String name) {
        List<User> names = userRepository.findUserByNameIgnoreCase(name);
        return names;
    }

    // TODO: terminar as outras funções
}
