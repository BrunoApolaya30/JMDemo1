package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente,Long>{
    
}
