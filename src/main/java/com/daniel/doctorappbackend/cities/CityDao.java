package com.daniel.doctorappbackend.cities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDao extends CrudRepository<City, Long> {
    List<City> findAll();

}
