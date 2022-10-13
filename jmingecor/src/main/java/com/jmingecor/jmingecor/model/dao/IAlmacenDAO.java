package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.Almacen;

public interface IAlmacenDAO extends CrudRepository<Almacen,Long> {
    
}
