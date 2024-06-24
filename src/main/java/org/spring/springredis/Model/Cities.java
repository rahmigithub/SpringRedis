package org.spring.springredis.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

//@RedisHash("cities")
//@Data
//@EqualsAndHashCode
@Entity
@Getter
@Setter
public class Cities  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String plateCode;
    private String cityName;





}
