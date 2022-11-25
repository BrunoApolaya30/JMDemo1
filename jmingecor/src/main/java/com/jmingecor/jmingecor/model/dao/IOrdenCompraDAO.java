package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.OrdenCompra;

public interface IOrdenCompraDAO extends CrudRepository<OrdenCompra,Long> {
    
}
