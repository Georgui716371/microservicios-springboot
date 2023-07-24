package com.proyect_actividad.main.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActividadesDao extends CrudRepository<Actividad, Long> {



}
