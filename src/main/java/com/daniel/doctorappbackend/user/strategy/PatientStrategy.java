package com.daniel.doctorappbackend.user.strategy;

import com.daniel.doctorappbackend.patient.PatientEntity;
import com.daniel.doctorappbackend.patient.PatientRepository;
import com.daniel.doctorappbackend.user.exception.UserNotFoundException;
import com.daniel.doctorappbackend.user.model.dto.PatientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientStrategy implements UserStrategy<PatientResponse>{
    private PatientRepository patientRepository;

    @Override
    public PatientResponse buildUser(String email, String password) throws UserNotFoundException {
        return this.patientRepository.findByUserEmailAndUserPassword(email, password)
                .map(this::mapToPatientResponse)
                .orElseThrow(UserNotFoundException::new);
    }

    private PatientResponse mapToPatientResponse(PatientEntity patientEntity){
        return PatientResponse.builder()
                .name(patientEntity.getUser().getName())
                .surname(patientEntity.getUser().getSurname())
                .email(patientEntity.getUser().getEmail())
                .userId(patientEntity.getUser().getId())
                .id(patientEntity.getId())
                .pesel(patientEntity.getPesel())
                .build();
    }
}
