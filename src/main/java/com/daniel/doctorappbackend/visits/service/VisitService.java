package com.daniel.doctorappbackend.visits.service;

import com.daniel.doctorappbackend.availabilitydoctor.model.AvailabilityDoctorEntity;
import com.daniel.doctorappbackend.city.model.dto.CityResponse;
import com.daniel.doctorappbackend.doctor.model.DoctorEntity;
import com.daniel.doctorappbackend.doctorServices.model.dto.DoctorServiceResponse;
import com.daniel.doctorappbackend.doctorServices.service.DoctorService;
import com.daniel.doctorappbackend.medicalservice.exception.MedicalServiceNotFoundException;
import com.daniel.doctorappbackend.medicalservice.model.MedicalServiceEntity;
import com.daniel.doctorappbackend.medicalservice.model.dto.MedicalServiceResponse;
import com.daniel.doctorappbackend.medicalservice.service.MedicalService;
import com.daniel.doctorappbackend.patient.PatientEntity;
import com.daniel.doctorappbackend.specialization.model.dto.SpecializationResponse;
import com.daniel.doctorappbackend.user.exception.UserNotFoundException;
import com.daniel.doctorappbackend.user.model.dto.DoctorResponse;
import com.daniel.doctorappbackend.user.strategy.PatientStrategy;
import com.daniel.doctorappbackend.visits.exception.VisitNotFoundException;
import com.daniel.doctorappbackend.visits.model.VisitEntity;
import com.daniel.doctorappbackend.visits.model.dto.UpdateVisitRequest;
import com.daniel.doctorappbackend.visits.model.dto.VisitResponse;
import com.daniel.doctorappbackend.visits.model.dto.VisitWithDoctorResponse;
import com.daniel.doctorappbackend.visits.model.dto.VisitWithDoctorResponse;
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
    private final DoctorService doctorService;

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

    public List<VisitResponse> findByPatientId(Long id) {
        return this.visitRepository.findAllByPatientId(id).stream().map(this::mapToResponse).collect(Collectors.toList());
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

    public VisitResponse getVisitById(Long id) throws VisitNotFoundException {
        return this.visitRepository.findById(id).map(this::mapToResponse).orElseThrow(() -> new VisitNotFoundException(id));
    }

    public VisitWithDoctorResponse getVisitWithDoctorById(Long id) throws VisitNotFoundException {
        return this.visitRepository.findById(id).map(this::mapToResponseWithDoctor).orElseThrow(() -> new VisitNotFoundException(id));
    }

    public VisitWithDoctorResponse mapToResponseWithDoctor(VisitEntity entity) {
        return VisitWithDoctorResponse.builder()
                .doctor(
                        DoctorResponse.builder()
                                .name(entity.getDoctor().getUser().getName())
                                .surname(entity.getDoctor().getUser().getSurname())
                                .email(entity.getDoctor().getUser().getEmail())
                                .userId(entity.getDoctor().getUser().getId())
                                .id(entity.getDoctor().getId())
                                .description(entity.getDoctor().getDescription())
                                .phoneNumber(entity.getDoctor().getPhoneNumber())
                                .address(entity.getDoctor().getAddress())
                                .userRole(entity.getDoctor().getUser().getRole())
                                .specialization(
                                        SpecializationResponse.builder()
                                                .id(entity.getDoctor().getSpecialization().getId())
                                                .name(entity.getDoctor().getSpecialization().getName())
                                                .build()
                                )
                                .city(
                                        CityResponse.builder()
                                                .id(entity.getDoctor().getCity().getId())
                                                .name(entity.getDoctor().getCity().getName())
                                                .build()
                                )
                                .doctorServices(
                                        doctorService.findByDoctorId(entity.getDoctor().getId())
                                                .stream()
                                                .map(
                                                        doctorServiceEntity -> DoctorServiceResponse.builder()
                                                                .id(doctorServiceEntity.getId())
                                                                .doctorId(entity.getDoctor().getId())
                                                                .medicalService(
                                                                        MedicalServiceResponse.builder()
                                                                                .id(doctorServiceEntity.getService().getId())
                                                                                .name(doctorServiceEntity.getService().getName())
                                                                                .length(doctorServiceEntity.getService().getLengthOfVisit())
                                                                                .build()
                                                                )
                                                                .price(doctorServiceEntity.getPrice())
                                                                .build()
                                                ).collect(Collectors.toList())
                                )
                                .visits(null)
                                .build()
                )
                .patientId(Optional.ofNullable(entity.getPatient()).map(PatientEntity::getId).orElse(null))
                .id(entity.getId())
                .from(entity.getFrom())
                .to(entity.getTo())
                .medicalService(
                        MedicalServiceResponse.builder()
                                .id(entity.getMedicalService().getId())
                                .name(entity.getMedicalService().getName())
                                .specialization(SpecializationResponse.builder()
                                        .id(entity.getMedicalService().getSpecialization().getId())
                                        .name(entity.getMedicalService().getSpecialization().getName())
                                        .build()
                                )
                                .build()
                )
                .availabilityId(Optional.ofNullable(entity.getAvailability()).map(AvailabilityDoctorEntity::getId).orElse(null))
                .build();
    }

    public List<VisitWithDoctorResponse> findWithDoctorByPatientId(Long patientId) {
        return this.visitRepository.findAllByPatientId(patientId).stream().map(this::mapToResponseWithDoctor).collect(Collectors.toList());
    }
}
