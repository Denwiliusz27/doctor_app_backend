package com.daniel.doctorappbackend.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceDao extends CrudRepository<Service, Long> {
    List<Service> findAll();

    List<Service> findAllBySpecializationId(Long specializationId);
}
