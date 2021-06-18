package com.daniel.doctorappbackend.patient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientDao extends CrudRepository<Patient, Long> {
    List<Patient> findAll();

    Optional<Patient> findByPatientPesel(String pesel);

    Optional<Patient> findByPatientEmailAddress(String email);
}
