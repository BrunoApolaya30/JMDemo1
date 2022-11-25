package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.DetalleOrdenCompra;

public interface IDetalleOrdenCompraService {

    public void guardarDetalleOrdenCompra(DetalleOrdenCompra detalleOrdenCompra);
    public List<DetalleOrdenCompra> cargarDetalleOrdenCompra();
    public DetalleOrdenCompra buscarDetalleOrdenCompra(Long id);

    public void eliminarDetalleOrdenCompra(Long id);
    
    Page<DetalleOrdenCompra> getAll(Pageable pageable);
}
