package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.ServicioCotizacion;

public interface IServicioCotizacionRepository extends JpaRepository<ServicioCotizacion,Long> {
    
}
