package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.Equipo;

public interface IEquipoDAO extends CrudRepository<Equipo,Long> {
    
}
