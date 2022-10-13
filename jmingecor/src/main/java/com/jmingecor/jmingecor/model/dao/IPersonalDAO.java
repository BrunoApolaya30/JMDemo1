package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.Personal;

public interface IPersonalDAO extends CrudRepository<Personal,Long> {
    
}
