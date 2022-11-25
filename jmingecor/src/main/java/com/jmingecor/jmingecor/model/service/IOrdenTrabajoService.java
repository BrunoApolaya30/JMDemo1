package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.OrdenTrabajo;

public interface IOrdenTrabajoService {
    public void guardarOrdenTrabajo(OrdenTrabajo ordenTrabajo);
    public List<OrdenTrabajo> cargarOrdenTrabajo();
    public OrdenTrabajo buscarOrdenTrabajo(Long id);

    public void eliminarOrdenTrabajo(Long id);
    
    Page<OrdenTrabajo> getAll(Pageable pageable);
}
