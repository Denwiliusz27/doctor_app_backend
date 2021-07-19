package com.daniel.doctorappbackend.doctorServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorServicesRepository extends JpaRepository<DoctorServiceEntity, Long> {
    List<DoctorServiceEntity> findAll();

    Optional<DoctorServiceEntity> findAllByServiceId(Long serviceId);

    List<DoctorServiceEntity> findAllByDoctorId(Long doctorId);
}
