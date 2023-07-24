package com.proyect_actividad.main.controller;

import com.proyect_actividad.main.model.Actividad;
import com.proyect_actividad.main.service.IActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/actividades")
public class ActividadesController {

    @Autowired
    private IActividadService actividadService;

    @GetMapping("/listar")
    public ResponseEntity<List<Actividad>> listar() {
        List<Actividad> actividades = actividadService.findAll();
        if (!actividades.isEmpty()) {
            return new ResponseEntity<>(actividades, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Actividad> crear( @RequestBody Actividad actividad) {
        Actividad actividadCreada = actividadService.save(actividad);
        if (actividadCreada != null) {
            return new ResponseEntity<>(actividadCreada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarActividad(@PathVariable Long id) {
        if (actividadService.findById(id) !=null) {
            actividadService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Actividad> actualizarActividad(@PathVariable Long id, @RequestBody Actividad actividad) {
        Actividad actividadActualizada = actividadService.findById(id);
        if (actividadActualizada != null) {
            actividadActualizada.setNombre(actividad.getNombre());
            actividadActualizada.setDescripcion(actividad.getDescripcion());
            actividadActualizada.setFecha(actividad.getFecha());
            actividadActualizada.setHora(actividad.getHora());
            actividadActualizada.setLugar(actividad.getLugar());
            actividadActualizada.setCosto(actividad.getCosto());
            actividadActualizada.setImagenes(actividad.getImagenes());
            actividadService.save(actividadActualizada);
            return new ResponseEntity<>(actividadActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
