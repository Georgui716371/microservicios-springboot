package com.servicepaquete.main.service;

import com.servicepaquete.main.model.IPaqueteDao;
import com.servicepaquete.main.model.Paquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteImpl implements IPaqueteService{

    @Autowired
    private IPaqueteDao paqueteDao;

    @Override
    public Paquete findById(Long id) {
        return paqueteDao.findById(id).orElse(null);
    }

    @Override
    public Paquete save(Paquete actividad) {
        return paqueteDao.save(actividad);
    }

    @Override
    public void delete(Long id) {
          paqueteDao.deleteById(id);
    }

    @Override
    public List<Paquete> findAll() {
        return (List<Paquete>) paqueteDao.findAll();
    }
}
