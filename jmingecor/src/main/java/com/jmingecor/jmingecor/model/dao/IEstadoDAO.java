package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.Estado;

public interface IEstadoDAO extends CrudRepository<Estado,Long> {
    
}
