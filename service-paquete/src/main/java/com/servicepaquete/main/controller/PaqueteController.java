package com.servicepaquete.main.controller;


import com.servicepaquete.main.model.Paquete;
import com.servicepaquete.main.service.PaqueteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/paquetes")
@RestController
public class PaqueteController {

    @Autowired
    private PaqueteImpl paqueteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Paquete>> listar() {
        List<Paquete> actividades = paqueteService.findAll();
        if (!actividades.isEmpty()) {
            return new ResponseEntity<>(actividades, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Paquete> crear( @RequestBody Paquete actividad) {
        Paquete actividadCreada = paqueteService.save(actividad);
        if (actividadCreada != null) {
            return new ResponseEntity<>(actividadCreada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarActividad(@PathVariable Long id) {
        if (paqueteService.findById(id) !=null) {
            paqueteService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Paquete> actualizarActividad(@PathVariable Long id, @RequestBody Paquete actividad) {
        Paquete actividadActualizada = paqueteService.findById(id);
        if (actividadActualizada != null) {

            actividadActualizada.setNombre(actividad.getNombre());
            actividadActualizada.setDescripcion(actividad.getDescripcion());
            actividadActualizada.setFechaSalida(actividad.getFechaSalida());
            actividadActualizada.setFechaRegreso(actividad.getFechaRegreso());
            actividadActualizada.setHora(actividad.getHora());
            actividadActualizada.setPrecio(actividad.getPrecio());
            actividadActualizada.setItinerario(actividad.getItinerario());
            paqueteService.save(actividadActualizada);
            return new ResponseEntity<>(actividadActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
