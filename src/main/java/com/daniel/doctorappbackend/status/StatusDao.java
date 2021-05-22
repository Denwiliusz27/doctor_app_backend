package com.daniel.doctorappbackend.status;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatusDao extends CrudRepository<Status, Long> {
    List<Status> findAll();

    Optional<Status> findStatusByIdStatusu(Long statusId);

    Optional<Status> findStatusByNazwa(String name);
}
