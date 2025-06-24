package br.com.medsync.services.patient;

import br.com.medsync.dto.PatientRequestDTO;
import br.com.medsync.dto.PatientResponseDTO;
import br.com.medsync.models.Patient;
import br.com.medsync.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // TODO: Implementar as outras funções
    @Override
    public void updatePatientById(Patient patient, String id) {

    }

    @Override
    public void deletePatientById(String id) {

    }
}
