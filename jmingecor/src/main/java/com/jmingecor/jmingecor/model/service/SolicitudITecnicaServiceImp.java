package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.ISolicitudITecnicaDAO;
import com.jmingecor.jmingecor.model.entity.SolicitudITecnica;
import com.jmingecor.jmingecor.model.repository.ISolicitudITecnicaRepository;

@Service
public class SolicitudITecnicaServiceImp implements ISolicitudITecnicaService{

    @Autowired
    private ISolicitudITecnicaDAO solicitudITecnicaDAO;

    @Autowired
    private ISolicitudITecnicaRepository solicitudITecnicaRepository; 

    @Override
    public void guardarSolicitudITecnica(SolicitudITecnica solicitudITecnica) {
        solicitudITecnicaDAO.save(solicitudITecnica);
        
    }

    @Override
    public List<SolicitudITecnica> cargarSolicitudITecnica() {
        
        return (List<SolicitudITecnica>) solicitudITecnicaDAO.findAll();
    }

    @Override
    public SolicitudITecnica buscarSolicitudITecnica(Long id_solicitudit) {
       
        return solicitudITecnicaDAO.findById(id_solicitudit).orElse(null);
    }

    @Override
    public void eliminarSolicitudITecnica(Long id_solicitudit) {
        solicitudITecnicaDAO.deleteById(id_solicitudit);
        
    }

    @Override
    public Page<SolicitudITecnica> getAll(Pageable pageable) {
     
        return solicitudITecnicaRepository.findAll(pageable);
    }
    
}
