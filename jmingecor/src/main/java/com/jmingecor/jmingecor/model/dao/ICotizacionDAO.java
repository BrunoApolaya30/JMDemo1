package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.Cotizacion;

public interface ICotizacionDAO extends CrudRepository<Cotizacion, Long>{
    
}
