package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.OrdenTrabajo;

public interface IOrdenTrabajoDAO extends CrudRepository<OrdenTrabajo, Long> {
    
}
