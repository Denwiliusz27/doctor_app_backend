package com.daniel.doctorappbackend.medicalservice.repository;

import com.daniel.doctorappbackend.medicalservice.model.MedicalServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalServiceRepository extends JpaRepository<MedicalServiceEntity, Long> {
    Optional<MedicalServiceEntity> findById(Long id);
    Optional<MedicalServiceEntity> findByName(String name);

    List<MedicalServiceEntity> findAll();

    List<MedicalServiceEntity> findAllBySpecializationId(Long specializationId);
}
