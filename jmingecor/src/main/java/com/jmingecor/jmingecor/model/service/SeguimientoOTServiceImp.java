package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.ISeguimientoOTDAO;
import com.jmingecor.jmingecor.model.entity.SeguimientoOT;
import com.jmingecor.jmingecor.model.repository.ISeguimientoOTRepository;

@Service
public class SeguimientoOTServiceImp implements ISeguimientoOTService {

    @Autowired
    private ISeguimientoOTDAO seguimientoOTDAO;

    @Autowired
    private ISeguimientoOTRepository seguimientoOTRepository;

    @Override
    public void guardarSeguimientoOT(SeguimientoOT seguimientoOT) {        
        seguimientoOTDAO.save(seguimientoOT);
    }

    @Override
    public List<SeguimientoOT> cargarSeguimientoOT() {        
        return (List<SeguimientoOT>) seguimientoOTDAO.findAll();
    }

    @Override
    public SeguimientoOT buscarSeguimientoOT(Long id_seguimiento_ot) {        
        return seguimientoOTDAO.findById(id_seguimiento_ot).orElse(null);
    }

    @Override
    public void eliminarSeguimientoOT(Long id_seguimiento_ot) {        
        seguimientoOTDAO.deleteById(id_seguimiento_ot);
    }

    @Override
    public Page<SeguimientoOT> getAll(Pageable pageable) {        
        return seguimientoOTRepository.findAll(pageable);
    }
    
}
