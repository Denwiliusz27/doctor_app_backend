package com.daniel.doctorappbackend.city;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CityService {
    private List<City> cities = new ArrayList<City>(Arrays.asList(
            new City("Lublin")
    ));

    public List<City> getAllCities() {
        return cities;
    }

    public void addCity(City city){
        cities.add(city);
    }
}
