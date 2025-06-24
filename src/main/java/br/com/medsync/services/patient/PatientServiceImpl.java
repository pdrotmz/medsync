package br.com.medsync.services.patient;

import br.com.medsync.dto.patient.PatientRequestDTO;
import br.com.medsync.dto.patient.PatientResponseDTO;
import br.com.medsync.dto.patient.RequestPasswordDTO;
import br.com.medsync.dto.patient.ResponsePasswordDTO;
import br.com.medsync.models.Patient;
import br.com.medsync.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientResponseDTO registerPatient(PatientRequestDTO request) {

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

    @Override
    public List<Patient> findAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    @Override
    public Optional<Patient> findPatientByCpf(String cpf) {
        Optional<Patient> optionalCpf = patientRepository.findPatientByCpf(cpf);
        return optionalCpf;
    }

    @Override
    public Optional<Patient> findPatientByEmail(String email) {
        Optional<Patient> optionalEmail = patientRepository.findPatientByEmail(email);

        if(optionalEmail.isEmpty() || optionalEmail == null) {
            throw new RuntimeException("Erro ao procurar paciente com esse email");
        }
        return optionalEmail;
    }

    @Override
    public List<Patient> findByBirthDate(LocalDate birthDate) {
        List<Patient> patients = patientRepository.findPatientByBirthDate(birthDate);
        return patients;
    }


    @Override
    @Modifying
    @Transactional
    public PatientResponseDTO updatePatientById(Patient updatedData, String id) {
        Patient existing = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente com id " + id + " não encontrado!"));

        existing.setUsername(updatedData.getUsername());
        existing.setName(updatedData.getName());
        existing.setEmail(updatedData.getEmail());
        existing.setCpf(updatedData.getCpf());
        existing.setBirthDate(updatedData.getBirthDate());

        Patient savedPatient = patientRepository.save(existing);

        return new PatientResponseDTO(
                savedPatient.getId(),
                savedPatient.getCpf(),
                savedPatient.getUsername(),
                savedPatient.getName(),
                savedPatient.getBirthDate(),
                savedPatient.getEmail(),
                savedPatient.getPassword()
        );
    }

    @Override
    public ResponsePasswordDTO updatedPatientPassword(RequestPasswordDTO request, String email) {
        Patient existing = patientRepository.findPatientByEmail(email)
                .orElseThrow(() -> new RuntimeException("Paciente com email " + email + " não encontrado!"));

        existing.setPassword(request.password());

        patientRepository.save(existing);

        return new ResponsePasswordDTO(
                "Senha atualizada com sucesso!"
        );
    }


    @Override
    @Modifying
    @Transactional
    public void deletePatientById(String id) {
       patientRepository.deleteById(id);
    }
}
