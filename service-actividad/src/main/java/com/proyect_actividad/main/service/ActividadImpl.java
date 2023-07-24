package com.proyect_actividad.main.service;

import com.proyect_actividad.main.model.Actividad;
import com.proyect_actividad.main.model.IActividadesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadImpl   implements IActividadService{

    @Autowired
    private IActividadesDao actividadDao;

    @Override
    public Actividad findById(Long id) {
        return actividadDao.findById(id).orElse(null);
    }

    @Override
    public Actividad save(Actividad actividad) {
        return actividadDao.save(actividad);
    }

    @Override
    public void delete(Long id) {
        actividadDao.deleteById(id);
    }

    @Override
    public List<Actividad> findAll() {
        return (List<Actividad>) actividadDao.findAll();
    }
}
