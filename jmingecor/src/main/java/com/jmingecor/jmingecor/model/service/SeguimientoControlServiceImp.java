package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.ISeguimientoControlDAO;
import com.jmingecor.jmingecor.model.entity.SeguimientoControl;
import com.jmingecor.jmingecor.model.repository.ISeguimientoControlRepository;

@Service
public class SeguimientoControlServiceImp implements ISeguimientoControlService {
    
    @Autowired
    private ISeguimientoControlDAO seguimientoControlDAO;

    @Autowired
    private ISeguimientoControlRepository seguimientoControlRepository;

    @Override
    public void guardarSeguimientoControl(SeguimientoControl seguimientoControl) {
        seguimientoControlDAO.save(seguimientoControl);
        
    }

    @Override
    public List<SeguimientoControl> cargarSeguimientosControl() {
        return (List<SeguimientoControl>) seguimientoControlDAO.findAll();
    }

    @Override
    public SeguimientoControl buscarSeguimientoControl(Long id_control) {
        return seguimientoControlDAO.findById(id_control).orElse(null);
    }

    @Override
    public void eliminarSeguimientoControl(Long id_control) {
        seguimientoControlDAO.deleteById(id_control);
        
    }

    @Override
    public Page<SeguimientoControl> getAll(Pageable pageable) {
        return seguimientoControlRepository.findAll(pageable);
    }

}
