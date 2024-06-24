package org.spring.springredis.Controller;

import org.spring.springredis.Model.Cities;
import org.spring.springredis.Service.CitiesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    private final CitiesService citiesService;

    public CitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping("/showAllCities")
    public List<Cities> showAllCities() {
        return citiesService.getAllCities();
    }

    @PostMapping("/addCities")
    public ResponseEntity<String> addCity(@RequestBody Cities cities) {
        return citiesService.addCities(cities);
    }

    @PutMapping("/updateCities")
    public Cities updateCity(@RequestBody Cities cities) {
        return citiesService.updateCities(cities);
    }

    @DeleteMapping("/deleteCitiesById/{id}")
    public void deleteCityById(@PathVariable Long id) {
        citiesService.deleteCities(id);
    }


}
