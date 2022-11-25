package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IOrdenCompraDAO;
import com.jmingecor.jmingecor.model.entity.OrdenCompra;
import com.jmingecor.jmingecor.model.repository.IOrdenCompraRepository;

@Service
public class OrdenCompraServiceImp implements IOrdenCompraService{

    @Autowired
    private IOrdenCompraDAO ordenCompraDAO;


    @Autowired
    private IOrdenCompraRepository ordenCompraRepository;

    @Override
    public void guardarOrdenCompra(OrdenCompra ordenCompra) {
        ordenCompraDAO.save(ordenCompra);
    }

    @Override
    public List<OrdenCompra> cargarOrdenCompra() {
        return (List<OrdenCompra>) ordenCompraDAO.findAll();
    }

    @Override
    public OrdenCompra buscarOrdenCompra(Long id) {
        return ordenCompraDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarOrdenCompra(Long id) {
        ordenCompraDAO.deleteById(id);
    }

    @Override
    public Page<OrdenCompra> getAll(Pageable pageable) {
        return ordenCompraRepository.findAll(pageable);
    }
    
}
