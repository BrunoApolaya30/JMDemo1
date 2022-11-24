package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.ISolicitudCompraDAO;
import com.jmingecor.jmingecor.model.entity.SolicitudCompra;
import com.jmingecor.jmingecor.model.repository.ISolicitudCompraRepository;

@Service
public class SolicitudCompraServiceImp implements  ISolicitudCompraService{
    
    @Autowired
    private ISolicitudCompraDAO solicitudCompraDAO;

    @Autowired
    private ISolicitudCompraRepository solicitudCompraRepository;

    @Override
    public void guardarSolicitudCompra(SolicitudCompra solicitudCompra){
        solicitudCompraDAO.save(solicitudCompra);
    }

    @Override
    public List<SolicitudCompra> cargarSolicitudCompra() {
        return (List<SolicitudCompra>) solicitudCompraDAO.findAll();
    }

    @Override
    public SolicitudCompra buscarSolicitudCompra(Long id_scompra) {
        return solicitudCompraDAO.findById(id_scompra).orElse(null);
    }

    @Override
    public void eliminarSolicitudCompra(Long id_scompra) {
        solicitudCompraDAO.deleteById(id_scompra);
    }

    @Override
    public Page<SolicitudCompra> getAll(Pageable pageable) {
        return solicitudCompraRepository.findAll(pageable);
    }

}
