package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.DetalleSolicitudCompra;

public interface IDetalleSolicitudCompraRepository extends JpaRepository<DetalleSolicitudCompra, Long> {
    
}
