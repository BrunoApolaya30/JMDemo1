package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.OrdenTrabajo;

public interface IOrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Long> {
    
}
