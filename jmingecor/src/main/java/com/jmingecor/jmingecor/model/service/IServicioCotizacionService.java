package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.ServicioCotizacion;

public interface IServicioCotizacionService {
    public void guardarServicioCotizacion(ServicioCotizacion servicioCotizacion);
    public List<ServicioCotizacion> cargarServicioCotizacion(Long idCot);
    public ServicioCotizacion buscarServicioCotizacion(Long id);

    public void eliminarServicioCotizacion(Long id);
    
    Page<ServicioCotizacion> getAll(Pageable pageable);

}
