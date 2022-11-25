package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.OrdenCompra;

public interface IOrdenCompraService {
    public void guardarOrdenCompra(OrdenCompra ordenCompra);
    public List<OrdenCompra> cargarOrdenCompra();
    public OrdenCompra buscarOrdenCompra(Long id);

    public void eliminarOrdenCompra(Long id);
    
    Page<OrdenCompra> getAll(Pageable pageable);
}
