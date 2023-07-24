package com.restaurante.main.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestauranteDao  extends CrudRepository<Restaurante, Long> {
}
