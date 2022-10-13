package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.Cargo;

public interface ICargoDAO extends CrudRepository<Cargo,Long>{
    
}
