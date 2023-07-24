package com.restaurante.main.service;

import com.restaurante.main.model.IRestauranteDao;
import com.restaurante.main.model.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteImpl implements IRestauranteService{

    @Autowired
    private IRestauranteDao restauranteDao;

    @Override
    public Restaurante findById(Long id) {
        return restauranteDao.findById(id).orElse(null);
    }

    @Override
    public Restaurante save(Restaurante actividad) {
        return restauranteDao.save(actividad);
    }

    @Override
    public void delete(Long id) {
        restauranteDao.deleteById(id);
    }

    @Override
    public List<Restaurante> findAll() {
        return (List<Restaurante>) restauranteDao.findAll();
    }
}
