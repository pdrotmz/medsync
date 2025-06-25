package br.com.medsync.services.doctor;

import br.com.medsync.dto.doctor.DoctorRequestDTO;
import br.com.medsync.dto.doctor.DoctorResponseDTO;

public interface DoctorService {
    DoctorResponseDTO registerDoctor(DoctorRequestDTO request);
    // TODO: Adicionar outras implementações
}
