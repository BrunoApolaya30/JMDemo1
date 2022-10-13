package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario,Long> {
    
}
