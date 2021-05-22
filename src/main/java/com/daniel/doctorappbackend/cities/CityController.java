package com.daniel.doctorappbackend.cities;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// stworzyc wyszukiwanie, mapping miasta po nazwie jak szukanie po idMaista
// dodanie (postMapping) nowego miasta /miasta/dodaj/{NazwaMiasta}

@RestController
@RequestMapping("/miasta")  // localhost:8080/miasta
public class CityController {
    public CityDao cityDao;

    public CityController(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @GetMapping("/wszystkie") // localhost:8080/miasta/wszystkie
    public List<City> getAllCities() {
        return cityDao.findAll();
    }

    @GetMapping("/id/{idMiasta}")
    public Optional<City> getCityById(@PathVariable Long idMiasta){
        return cityDao.findById(idMiasta);
    }

    @GetMapping("/nazwa/{nazwa}")
    public Optional<City> getCityByName(@PathVariable String nazwa){
        return cityDao.findByNazwa(nazwa);
    }

    @PostMapping("/dodaj/{nazwa}")
    public City addNewCity(@PathVariable String nazwa){
        return new City(nazwa);
    }

}
