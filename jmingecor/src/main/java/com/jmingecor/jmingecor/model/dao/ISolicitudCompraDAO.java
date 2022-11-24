package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.SolicitudCompra;

public interface  ISolicitudCompraDAO extends CrudRepository<SolicitudCompra,Long> {
    
}
