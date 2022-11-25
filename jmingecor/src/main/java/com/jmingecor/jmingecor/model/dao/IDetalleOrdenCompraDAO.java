package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.DetalleOrdenCompra;

public interface IDetalleOrdenCompraDAO extends CrudRepository<DetalleOrdenCompra,Long> {
    
}
