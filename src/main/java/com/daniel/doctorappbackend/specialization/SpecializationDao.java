package com.daniel.doctorappbackend.specialization;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecializationDao extends CrudRepository<Specialization, Long> {
    List<Specialization> findAll();

    Optional<Specialization> findBySpecializationName(String specializationName);
}
