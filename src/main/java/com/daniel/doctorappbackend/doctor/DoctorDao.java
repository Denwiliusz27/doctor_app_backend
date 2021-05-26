package com.daniel.doctorappbackend.doctor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorDao extends CrudRepository<Doctor, Long> {
    List<Doctor> findAll();

    Optional<Doctor> findByUserId(Long userId);

    List<Doctor> findAllBySpecializationId(Long specializationId);

    List<Doctor> findAllByCityId(Long cityId);
}
