package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.SolicitudRequerimiento;

public interface ISolicitudRequerimientoRepository extends JpaRepository<SolicitudRequerimiento, Long>{
    
}
