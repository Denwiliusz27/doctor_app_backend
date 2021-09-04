package com.daniel.doctorappbackend.visits.repository;

import com.daniel.doctorappbackend.visits.model.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface VisitRepository extends JpaRepository<VisitEntity, Long> {
    void deleteByAvailabilityId(Long id);
    List<VisitEntity> findAllByDoctorId(Long id);
    List<VisitEntity> findAllByDoctorIdAndPatientIsNullAndFromIsAfter(Long doctorId, Date date);
    List<VisitEntity> findAllByPatientId(Long id);
    List<VisitEntity> findAllByDoctorIdAndPatientIsNotNull(Long id);
}
