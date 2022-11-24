package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.ICotizacionDAO;
import com.jmingecor.jmingecor.model.entity.Cotizacion;
import com.jmingecor.jmingecor.model.repository.ICotizacionRepository;

@Service
public class CotizacionServiceImp implements ICotizacionService{

    @Autowired
    private ICotizacionDAO cotizacionDAO;


    @Autowired
    private ICotizacionRepository cotizacionRepository;

    @Override
    public void guardarCotizacion(Cotizacion cotizacion) {
        cotizacionDAO.save(cotizacion);
    }

    @Override
    public List<Cotizacion> cargarCotizaciones() {
        return (List<Cotizacion>) cotizacionDAO.findAll();
    }

    @Override
    public Cotizacion buscarCotizacion(Long id) {
        return cotizacionDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarCotizacion(Long id) {
        cotizacionDAO.deleteById(id);
    }

    @Override
    public Page<Cotizacion> getAll(Pageable pageable) {
        return cotizacionRepository.findAll(pageable);
    }
    
}
