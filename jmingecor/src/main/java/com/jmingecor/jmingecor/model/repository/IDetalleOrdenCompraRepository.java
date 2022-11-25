package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.DetalleOrdenCompra;

public interface IDetalleOrdenCompraRepository extends JpaRepository<DetalleOrdenCompra,Long> {
    
}
