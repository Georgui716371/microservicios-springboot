package com.servicepaquete.main.openfeignclient;


import com.servicepaquete.main.model.Restaurante;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name="service-restaurante",url = "localhost:8081/restaurantes")
public interface RestauranteFeign {

    @PostMapping()
    Restaurante save(Restaurante actividad);

    @GetMapping("/byRestaurante/{id}")
    List<Restaurante> findByPaqueteId(@PathVariable("id") Long id);

}
