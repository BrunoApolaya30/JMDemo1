package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.ISeguimientoCotizacionesDAO;
import com.jmingecor.jmingecor.model.entity.SeguimientoCotizaciones;
import com.jmingecor.jmingecor.model.repository.ISeguimientoCotizacionesRepository;

@Service
public class SeguimientoCotizacionesServiceImp implements ISeguimientoCotizacionesService{

    @Autowired
    private ISeguimientoCotizacionesDAO seguimientoCotizacionesDAO;

    @Autowired
    private ISeguimientoCotizacionesRepository seguimientoCotizacionesRepository;


    @Override
    public void guardarSeguimientoCotizaciones(SeguimientoCotizaciones seguimientoCotizaciones) {        
        seguimientoCotizacionesDAO.save(seguimientoCotizaciones);
    }

    @Override
    public List<SeguimientoCotizaciones> cargarSeguimientoCotizaciones() {        
        return (List<SeguimientoCotizaciones>) seguimientoCotizacionesDAO.findAll();
    }

    @Override
    public SeguimientoCotizaciones buscarSeguimientoCotizaciones(Long id_scotizaciones) {        
        return seguimientoCotizacionesDAO.findById(id_scotizaciones).orElse(null);
    }

    @Override
    public void eliminarSeguimientoCotizaciones(Long id_scotizaciones) {        
        seguimientoCotizacionesDAO.deleteById(id_scotizaciones);
    }

    @Override
    public Page<SeguimientoCotizaciones> getAll(Pageable pageable) {        
        return seguimientoCotizacionesRepository.findAll(pageable);
    }
    
}
