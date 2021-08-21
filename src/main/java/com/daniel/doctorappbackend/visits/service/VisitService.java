package com.daniel.doctorappbackend.visits.service;

import com.daniel.doctorappbackend.availabilitydoctor.model.AvailabilityDoctorEntity;
import com.daniel.doctorappbackend.doctor.model.DoctorEntity;
import com.daniel.doctorappbackend.medicalservice.exception.MedicalServiceNotFoundException;
import com.daniel.doctorappbackend.medicalservice.model.MedicalServiceEntity;
import com.daniel.doctorappbackend.medicalservice.service.MedicalService;
import com.daniel.doctorappbackend.patient.PatientEntity;
import com.daniel.doctorappbackend.user.exception.UserNotFoundException;
import com.daniel.doctorappbackend.user.strategy.PatientStrategy;
import com.daniel.doctorappbackend.visits.exception.VisitNotFoundException;
import com.daniel.doctorappbackend.visits.model.VisitEntity;
import com.daniel.doctorappbackend.visits.model.dto.UpdateVisitRequest;
import com.daniel.doctorappbackend.visits.model.dto.VisitResponse;
import com.daniel.doctorappbackend.visits.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final VisitRepository visitRepository;
    private final PatientStrategy patientStrategy;
    private final MedicalService medicalService;

    public VisitResponse mapToResponse(VisitEntity entity) {
        return VisitResponse.builder()
                .doctorId(Optional.ofNullable(entity.getDoctor()).map(DoctorEntity::getId).orElse(null))
                .patientId(Optional.ofNullable(entity.getPatient()).map(PatientEntity::getId).orElse(null))
                .id(entity.getId())
                .from(entity.getFrom())
                .to(entity.getTo())
                .medicalServiceId(Optional.ofNullable(entity.getMedicalService()).map(MedicalServiceEntity::getId).orElse(null))
                .availabilityId(Optional.ofNullable(entity.getAvailability()).map(AvailabilityDoctorEntity::getId).orElse(null))
                .build();
    }

    public List<VisitResponse> findByDoctorId(Long id) {
        return this.visitRepository.findAllByDoctorId(id).stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public void addVisits(DoctorEntity doctorEntity, AvailabilityDoctorEntity availabilityDoctorEntity, Date from, Date to) {
        Date temp = (Date)from.clone();
        long newTime;
        while (temp.before(to)) {
            newTime = temp.toInstant().plus(30, ChronoUnit.MINUTES).toEpochMilli();
            visitRepository.save(
                    VisitEntity.builder()
                            .doctor(doctorEntity)
                            .availability(availabilityDoctorEntity)
                            .from(new Date(temp.getTime()))
                            .to(new Date(newTime))
                            .build()
            );
            temp.setTime(newTime);
        }
    }

    public void removeVisits(Long availabilityId) {
        this.visitRepository.deleteByAvailabilityId(availabilityId);
    }

    public List<VisitResponse> findFreeVisits(Long doctorId) {
        return this.visitRepository.findAllByDoctorIdAndPatientIsNull(doctorId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public VisitResponse updateVisit(UpdateVisitRequest visitRequest) throws VisitNotFoundException, UserNotFoundException, MedicalServiceNotFoundException {
        VisitEntity visit = this.visitRepository.findById(visitRequest.getId()).orElseThrow(() -> new VisitNotFoundException(visitRequest.getId()));
        PatientEntity patientEntity = this.patientStrategy.findPatientById(visitRequest.getPatientId()).orElseThrow(UserNotFoundException::new);
        MedicalServiceEntity medicalServiceEntity = this.medicalService.findById(visitRequest.getServiceId()).orElseThrow(() ->
                new MedicalServiceNotFoundException(visitRequest.getServiceId()));
        visit.setPatient(patientEntity);
        visit.setMedicalService(medicalServiceEntity);
        this.visitRepository.save(visit);
        return this.mapToResponse(visit);
    }
}
