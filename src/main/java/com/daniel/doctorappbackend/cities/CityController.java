package com.daniel.doctorappbackend.cities;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// stworzyc wyszukiwanie, mapping miasta po nazwie jak szukanie po idMaista
// dodanie (postMapping) nowego miasta /miasta/dodaj/{NazwaMiasta}

@RestController
@RequestMapping("/miasta")
public class CityController {
    public CityDao cityDao;

    public CityController(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @GetMapping("/wszystkie")
    public List<City> getAllCities() {
        return cityDao.findAll();
    }

    @GetMapping("/{idMiasta}")
    public Optional<City> getCityById(@PathVariable Long idMiasta){
        return cityDao.findById(idMiasta);
    }
}
