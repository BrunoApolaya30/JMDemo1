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
        // TODO Auto-generated method stub
        seguimientoCotizacionesDAO.save(seguimientoCotizaciones);
    }

    @Override
    public List<SeguimientoCotizaciones> cargarSeguimientoCotizaciones() {
        // TODO Auto-generated method stub
        return (List<SeguimientoCotizaciones>) seguimientoCotizacionesDAO.findAll();
    }

    @Override
    public SeguimientoCotizaciones buscarSeguimientoCotizaciones(Long id_scotizaciones) {
        // TODO Auto-generated method stub
        return seguimientoCotizacionesDAO.findById(id_scotizaciones).orElse(null);
    }

    @Override
    public void eliminarSeguimientoCotizaciones(Long id_scotizaciones) {
        // TODO Auto-generated method stub
        seguimientoCotizacionesDAO.deleteById(id_scotizaciones);
    }

    @Override
    public Page<SeguimientoCotizaciones> getAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return seguimientoCotizacionesRepository.findAll(pageable);
    }
    
}
