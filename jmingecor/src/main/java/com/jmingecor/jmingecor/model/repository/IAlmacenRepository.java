package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.Almacen;

public interface IAlmacenRepository extends JpaRepository<Almacen,Long> {
    
}
