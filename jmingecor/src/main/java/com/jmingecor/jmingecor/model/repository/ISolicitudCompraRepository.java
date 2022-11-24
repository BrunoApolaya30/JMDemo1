package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.SolicitudCompra;

public interface  ISolicitudCompraRepository extends JpaRepository<SolicitudCompra, Long>{
    
}
