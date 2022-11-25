package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.ISolicitudRequerimientoDAO;
import com.jmingecor.jmingecor.model.entity.SolicitudRequerimiento;
import com.jmingecor.jmingecor.model.repository.ISolicitudRequerimientoRepository;

@Service
public class SolicitudRequerimientoServiceImp implements ISolicitudRequerimientoService{

    @Autowired
    private ISolicitudRequerimientoDAO solicitudRequerimientoDAO;

    @Autowired
    private ISolicitudRequerimientoRepository solicitudRequerimientoRepository;

    @Override
    public void guardarSolicitudRequerimiento(SolicitudRequerimiento solicitudRequerimiento) {
        solicitudRequerimientoDAO.save(solicitudRequerimiento);
        
    }

    @Override
    public List<SolicitudRequerimiento> cargarSolicitudRequerimiento() {
        
        return (List<SolicitudRequerimiento>) solicitudRequerimientoDAO.findAll();
    }

    @Override
    public SolicitudRequerimiento buscarSolicitudRequerimiento(Long id_solicitudr) {
       
        return solicitudRequerimientoDAO.findById(id_solicitudr).orElse(null);
    }

    @Override
    public void eliminarSolicitudRequerimiento(Long id_solicitudr) {
        solicitudRequerimientoDAO.deleteById(id_solicitudr);
        
    }

    @Override
    public Page<SolicitudRequerimiento> getAll(Pageable pageable) {
       
        return solicitudRequerimientoRepository.findAll(pageable);
    }
    
}
