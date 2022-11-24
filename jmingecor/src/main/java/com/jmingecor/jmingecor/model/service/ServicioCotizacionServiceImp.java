package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IServicioCotizacionDAO;
import com.jmingecor.jmingecor.model.entity.ServicioCotizacion;
import com.jmingecor.jmingecor.model.repository.IServicioCotizacionRepository;

@Service
public class ServicioCotizacionServiceImp implements IServicioCotizacionService {

    @Autowired
    private IServicioCotizacionDAO servicioCotizacionDAO;


    @Autowired
    private IServicioCotizacionRepository servicioCotizacionRepository;


    @Override
    public void guardarServicioCotizacion(ServicioCotizacion servicioCotizacion) {
        servicioCotizacionDAO.save(servicioCotizacion);
    }

    @Override
    public List<ServicioCotizacion> cargarServicioCotizacion(Long idCot) {
        return servicioCotizacionDAO.cargarServCotizacion(idCot);
    }

    @Override
    public ServicioCotizacion buscarServicioCotizacion(Long id) {
        return servicioCotizacionDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarServicioCotizacion(Long id) {
        servicioCotizacionDAO.deleteById(id);
    }

    @Override
    public Page<ServicioCotizacion> getAll(Pageable pageable) {
        return servicioCotizacionRepository.findAll(pageable);
    }
    
    
}
