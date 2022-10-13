package com.jmingecor.jmingecor.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.Categoria;

public interface ICategoriaDAO  extends CrudRepository<Categoria,Long>{
    
}
