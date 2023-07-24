package com.restaurante.main.controller;

import com.restaurante.main.model.Restaurante;
import com.restaurante.main.service.RestauranteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/restaurante")
@RestController
public class RestauranteController {

    @Autowired
    private RestauranteImpl restauranteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Restaurante>> listar() {
        List<Restaurante> restauranteDev = restauranteService.findAll();
        if (!restauranteDev.isEmpty()) {
            return new ResponseEntity<>(restauranteDev, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Restaurante> crear(@RequestBody  Restaurante actividad) {
        Restaurante actividadCreada = restauranteService.save(actividad);
        if (actividadCreada != null) {
            return new ResponseEntity<>(actividadCreada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarRestaurante(@PathVariable Long id) {
        if (restauranteService.findById(id) !=null) {
            restauranteService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Restaurante> actualizarRestaurante(@PathVariable Long id,  Restaurante restaurante) {
        Restaurante restauranteDev = restauranteService.findById(id);
        if (restauranteDev != null) {
            restauranteDev.setNombre(restaurante.getNombre());
            restauranteDev.setDescripcion(restaurante.getDescripcion());
            restauranteDev.setDireccion(restaurante.getDireccion());
            restauranteDev.setTelefono(restaurante.getTelefono());
            restauranteDev.setHorario(restaurante.getHorario());
            return new ResponseEntity<>(restauranteDev, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
