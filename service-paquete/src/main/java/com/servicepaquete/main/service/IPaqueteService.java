package com.servicepaquete.main.service;

import com.servicepaquete.main.model.Paquete;

import java.util.List;

public interface IPaqueteService {

    public Paquete findById(Long id);
    public Paquete save(Paquete actividad);
    public void delete(Long id);
    public List<Paquete> findAll();

}
