package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.OrdenCompra;

public interface IOrdenCompraRepository extends JpaRepository<OrdenCompra,Long> {
    
}
