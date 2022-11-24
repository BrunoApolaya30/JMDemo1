package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.Cotizacion;

public interface ICotizacionService {
    public void guardarCotizacion(Cotizacion cotizacion);
    public List<Cotizacion> cargarCotizaciones();
    public Cotizacion buscarCotizacion(Long id);
    public void eliminarCotizacion(Long id);
    
    Page<Cotizacion> getAll(Pageable pageable);
}
