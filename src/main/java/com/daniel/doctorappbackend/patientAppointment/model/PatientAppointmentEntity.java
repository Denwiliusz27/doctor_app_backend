package com.daniel.doctorappbackend.patientAppointment.model;

import com.daniel.doctorappbackend.availabilitydoctor.model.AvailabilityDoctorEntity;
import com.daniel.doctorappbackend.doctorServices.model.DoctorServiceEntity;
import com.daniel.doctorappbackend.medicalservice.model.MedicalServiceEntity;
import com.daniel.doctorappbackend.patient.PatientEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "patients_appointments")
public class PatientAppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    @Column(name = "date_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date from;

    @Column(name = "date_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date to;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_availability_id")
    private AvailabilityDoctorEntity doctorAvailability;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private MedicalServiceEntity service;
}
