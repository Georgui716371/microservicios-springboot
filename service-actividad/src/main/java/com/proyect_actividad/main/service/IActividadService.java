package com.proyect_actividad.main.service;

import com.proyect_actividad.main.model.Actividad;
import com.proyect_actividad.main.model.IActividadesDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IActividadService {



    public Actividad findById(Long id);
    public Actividad save(Actividad actividad);
    public void delete(Long id);
    public List<Actividad> findAll();


}
