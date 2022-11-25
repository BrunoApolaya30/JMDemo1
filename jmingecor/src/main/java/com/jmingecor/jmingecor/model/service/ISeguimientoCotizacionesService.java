package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.SeguimientoCotizaciones;

public interface ISeguimientoCotizacionesService {
    public void guardarSeguimientoCotizaciones(SeguimientoCotizaciones seguimientoCotizaciones);
    public List<SeguimientoCotizaciones> cargarSeguimientoCotizaciones();
    public SeguimientoCotizaciones buscarSeguimientoCotizaciones(Long id_scotizaciones);

    public void eliminarSeguimientoCotizaciones(Long id_scotizaciones);
    
    Page<SeguimientoCotizaciones> getAll(Pageable pageable);
}
