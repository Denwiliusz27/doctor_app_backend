package com.daniel.doctorappbackend.city.repository;

import com.daniel.doctorappbackend.city.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

}
