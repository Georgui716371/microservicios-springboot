package com.servicepaquete.main.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaqueteDao extends CrudRepository<Paquete, Long> {
}
