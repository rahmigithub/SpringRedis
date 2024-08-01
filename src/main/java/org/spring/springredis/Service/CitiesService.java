package org.spring.springredis.Service;

import org.spring.springredis.Model.Cities;
import org.spring.springredis.Repository.CitiesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesService {

    private final CitiesRepository citiesRepository;

    public CitiesService(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    public List<Cities> getAllCities() {
        return (List<Cities>) citiesRepository.findAll();
    }

    public Cities getCitiesById(Long id) {

        return citiesRepository.findById(id).orElseThrow(() -> new RuntimeException("City is not found with id:" + id));
    }

    public ResponseEntity<String> addCities(Cities cities) {

        if (!citiesRepository.existsByPlateCodeAndCityName(cities.getPlateCode(),cities.getCityName())) {
            citiesRepository.save(cities);
            return ResponseEntity.ok("Save request successful");
        }else {
            System.out.println("Git için Deneme");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Save request failed. This city already exists");
        }

    }

    public Cities updateCities(Cities cities) {


        Cities oldCities = citiesRepository.findById(cities.getId()).orElseThrow(() -> new RuntimeException("City is not found with id:" + cities.getId()));

        oldCities.setPlateCode(cities.getPlateCode());
        oldCities.setCityName(cities.getCityName());

        return citiesRepository.save(oldCities);
    }

    public void deleteCities(Long id) {

        Cities deletedCities = citiesRepository.findById(id).orElseThrow(() -> new RuntimeException("City is not found with id:" + id));

        citiesRepository.delete(deletedCities);
    }

}
