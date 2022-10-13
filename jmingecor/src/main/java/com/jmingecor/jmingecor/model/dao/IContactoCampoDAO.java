package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.ContactoCampo;

public interface IContactoCampoDAO extends CrudRepository<ContactoCampo,Long> {
    
}
