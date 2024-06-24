package org.spring.springredis.Repository;

import org.spring.springredis.Model.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitiesRepository extends CrudRepository<Cities, Long> {

    boolean existsByPlateCodeAndCityName(String plateCode, String cityName);

}
