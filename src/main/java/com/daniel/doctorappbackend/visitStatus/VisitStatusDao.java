package com.daniel.doctorappbackend.visitStatus;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitStatusDao extends CrudRepository<VisitStatus, Long> {
    List<VisitStatus> findAll();

    Optional<VisitStatus> findStatusByStatusId(Long statusId);

    Optional<VisitStatus> findStatusByStatusName(String name);
}
