package com.daniel.doctorappbackend.cities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityDao extends CrudRepository<City, Long> {
    List<City> findAll();

    Optional<City> findByNazwa(String nazwa);
}
