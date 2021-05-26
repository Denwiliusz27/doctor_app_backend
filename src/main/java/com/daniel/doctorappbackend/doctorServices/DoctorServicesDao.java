package com.daniel.doctorappbackend.doctorServices;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorServicesDao extends CrudRepository<DoctorServices, Long> {
    List<DoctorServices> findAll();

    Optional<DoctorServices> findAllByServiceId(Long serviceId);

    List<DoctorServices> findAllByDoctorId(Long doctorId);
}
