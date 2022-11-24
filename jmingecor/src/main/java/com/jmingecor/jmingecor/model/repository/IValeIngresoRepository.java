package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.ValeIngreso;

public interface  IValeIngresoRepository extends JpaRepository<ValeIngreso, Long> {
    
}
