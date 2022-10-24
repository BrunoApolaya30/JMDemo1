package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria,Long> {
    
}
