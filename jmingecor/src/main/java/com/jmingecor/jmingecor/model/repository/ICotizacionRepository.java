package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.Cotizacion;

public interface ICotizacionRepository extends JpaRepository<Cotizacion, Long>{
    
}
