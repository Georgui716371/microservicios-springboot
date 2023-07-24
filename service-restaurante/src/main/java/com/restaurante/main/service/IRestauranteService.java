package com.restaurante.main.service;

import com.restaurante.main.model.Restaurante;

import java.util.List;

public interface IRestauranteService {
    public Restaurante findById(Long id);
    public Restaurante save(Restaurante actividad);
    public void delete(Long id);
    public List<Restaurante> findAll();
}
