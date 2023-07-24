package com.servicepaquete.main.openfeignclient;

import com.servicepaquete.main.model.Actividad;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name="servicio-actividad")
@RequestMapping("/actividades")
public interface ActividadFeign {

    @PostMapping()
    Actividad save(Actividad actividad);

    @GetMapping("/byPaquete/{id}")
    List<Actividad> findByPaqueteId(@PathVariable("id") Long id);


}
