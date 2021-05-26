package com.daniel.doctorappbackend.specialization;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecializationDao extends CrudRepository<Specialization, Long> {
    List<Specialization> findAll();
}
