package com.daniel.doctorappbackend.doctor.repository;

import com.daniel.doctorappbackend.doctor.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    List<DoctorEntity> findAll();
    Optional<DoctorEntity> findByUserEmailAndUserPassword(String email, String password);
    Optional<DoctorEntity> findByUserEmail(String email);
    List<DoctorEntity> findByCityIdAndSpecializationId(Long cityId, Long specializationId);
}
