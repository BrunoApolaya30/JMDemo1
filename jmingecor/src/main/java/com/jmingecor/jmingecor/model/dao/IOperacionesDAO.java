package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.Operaciones;

public interface IOperacionesDAO extends CrudRepository<Operaciones,Long> {
    
}
