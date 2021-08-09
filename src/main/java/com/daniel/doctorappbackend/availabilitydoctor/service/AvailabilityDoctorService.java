package com.daniel.doctorappbackend.availabilitydoctor.service;

import com.daniel.doctorappbackend.availabilitydoctor.model.AvailabilityDoctorEntity;
import com.daniel.doctorappbackend.availabilitydoctor.model.dto.AvailabilityDoctorResponse;
import com.daniel.doctorappbackend.availabilitydoctor.model.dto.CreateAvailabilityDoctorRequest;
import com.daniel.doctorappbackend.availabilitydoctor.repository.AvailabilityDoctorRepository;
import com.daniel.doctorappbackend.doctor.model.DoctorEntity;
import com.daniel.doctorappbackend.user.exception.UserNotFoundException;
import com.daniel.doctorappbackend.user.strategy.DoctorStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AvailabilityDoctorService {
    private final AvailabilityDoctorRepository availabilityDoctorRepository;
    private final DoctorStrategy doctorStrategy;

    public AvailabilityDoctorResponse add(CreateAvailabilityDoctorRequest request) throws UserNotFoundException {
        DoctorEntity doctorEntity = doctorStrategy.findById(request.getDoctorId()).orElseThrow(UserNotFoundException::new);
        return this.mapToAvailabilityDoctorResponse(
                availabilityDoctorRepository.save(
                        AvailabilityDoctorEntity.builder()
                                .doctor(doctorEntity)
                                .from(request.getFrom())
                                .to(request.getTo())
                                .build()
                )
        );
    }

    private AvailabilityDoctorResponse mapToAvailabilityDoctorResponse(AvailabilityDoctorEntity availabilityDoctorEntity) {
        return AvailabilityDoctorResponse.builder()
                .doctorId(availabilityDoctorEntity.getDoctor().getId())
                .id(availabilityDoctorEntity.getId())
                .from(availabilityDoctorEntity.getFrom())
                .to(availabilityDoctorEntity.getTo())
                .build();
    }

    public void delete(Long id) {
         availabilityDoctorRepository.deleteById(id);
    }

    public List<AvailabilityDoctorResponse> findByDoctorId(Long doctorId) {
        return availabilityDoctorRepository
                .findAllByDoctorId(doctorId)
                .stream()
                .map(this::mapToAvailabilityDoctorResponse)
                .collect(Collectors.toList());
    }
}
