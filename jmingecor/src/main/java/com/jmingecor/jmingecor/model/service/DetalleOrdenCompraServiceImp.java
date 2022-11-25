package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IDetalleOrdenCompraDAO;
import com.jmingecor.jmingecor.model.entity.DetalleOrdenCompra;
import com.jmingecor.jmingecor.model.repository.IDetalleOrdenCompraRepository;

@Service
public class DetalleOrdenCompraServiceImp implements IDetalleOrdenCompraService {

    @Autowired
    private IDetalleOrdenCompraDAO detalleOrdenCompraDAO;


    @Autowired
    private IDetalleOrdenCompraRepository detalleOrdenCompraRepository;

    @Override
    public void guardarDetalleOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) {
        detalleOrdenCompraDAO.save(detalleOrdenCompra);
    }

    @Override
    public List<DetalleOrdenCompra> cargarDetalleOrdenCompra() {
        return (List<DetalleOrdenCompra>) detalleOrdenCompraDAO.findAll();
    }

    @Override
    public DetalleOrdenCompra buscarDetalleOrdenCompra(Long id) {
        return detalleOrdenCompraDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarDetalleOrdenCompra(Long id) {
        detalleOrdenCompraDAO.deleteById(id);
    }

    @Override
    public Page<DetalleOrdenCompra> getAll(Pageable pageable) {
        return detalleOrdenCompraRepository.findAll(pageable);
    }
    
}
