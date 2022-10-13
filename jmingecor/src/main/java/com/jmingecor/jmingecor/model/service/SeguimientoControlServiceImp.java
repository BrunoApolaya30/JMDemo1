package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.ISeguimientoControlDAO;
import com.jmingecor.jmingecor.model.entity.SeguimientoControl;

@Service
public class SeguimientoControlServiceImp implements ISeguimientoControlService {
    
    @Autowired
    private ISeguimientoControlDAO seguimientoControlDAO;

    @Override
    public void guardarSeguimientoControl(SeguimientoControl seguimientoControl) {
        seguimientoControlDAO.save(seguimientoControl);
        
    }

    @Override
    public List<SeguimientoControl> cargarSeguimientosControl() {
        return (List<SeguimientoControl>) seguimientoControlDAO.findAll();
    }

    @Override
    public SeguimientoControl buscarSeguimientoControl(Long id) {
        return seguimientoControlDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarSeguimientoControl(Long id) {
        seguimientoControlDAO.deleteById(id);
        
    }

}
