package com.daniel.doctorappbackend.appointment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentDao extends CrudRepository<Appointment, Long> {
    List<Appointment> findAll();

    Optional<Appointment> findByDoctorId(long doctorId);

    Optional<Appointment> findByPatientId(long patientId);

    Optional<Appointment> findByServiceId(long serviceId);

    Optional<Appointment> findByDayId(long dayId);

    Optional<Appointment> findByStatusId(long statusId);
}
