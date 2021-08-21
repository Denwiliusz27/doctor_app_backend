package com.daniel.doctorappbackend.patientAppointment.repository;

import com.daniel.doctorappbackend.patientAppointment.model.PatientAppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientAppointmentRepository extends JpaRepository<PatientAppointmentEntity, Long> {
    List<PatientAppointmentEntity> findAll();

    /*Optional<PatientAppointmentEntity> findByDoctorId(long doctorId);*/

    List<PatientAppointmentEntity> findByPatientId(long patientId);


    /*Optional<PatientAppointmentEntity> findByServiceId(long serviceId);

    Optional<PatientAppointmentEntity> findByDayId(long dayId);

    Optional<PatientAppointmentEntity> findByStatusId(long statusId);*/
}
