package com.daniel.doctorappbackend.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// dodanie (postMapping) nowego miasta /miasta/dodaj/{NazwaMiasta}

@RestController
@RequestMapping("/miasta")  // localhost:8080/miasta
public class CityController {
    public CityDao cityDao;

    @Autowired
    private CityService cityService;

    public CityController(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @GetMapping("/wszystkie") // localhost:8080/miasta/wszystkie
    public List<City> getAllCities() {
        return cityDao.findAll();
    }

    @GetMapping("/id/{cityId}")
    public Optional<City> getCityById(@PathVariable long cityId){
        return cityDao.findById(cityId);
    }

    @GetMapping("/nazwa/{cityName}")
    public Optional<City> getCityByName(@PathVariable String cityName){
        return cityDao.findByCityName(cityName);
    }

    @PostMapping("/dodaj")
    public void addNewCity(){
        System.out.println("tutaj powinno cos byc");
        System.console().writer().println("no witam tutaj metodka post");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dodajm")
    public void addCity(@RequestBody City city) {
        cityService.addCity(city);
        //cityDao.save(city);
        System.out.println("tutaj powinno cos byc");
        System.console().writer().println("no witam tutaj metodka post");
    }

}
