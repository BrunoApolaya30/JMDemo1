package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.Equipo;

public interface IEquipoRepository extends JpaRepository<Equipo,Long> {
    
}
