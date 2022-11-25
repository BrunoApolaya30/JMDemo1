package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.SeguimientoControl;

public interface ISeguimientoControlService {
    public void guardarSeguimientoControl(SeguimientoControl seguimientoControl);
    public List<SeguimientoControl> cargarSeguimientosControl();
    public SeguimientoControl buscarSeguimientoControl(Long id_control);
    public void eliminarSeguimientoControl(Long id_control);

    Page<SeguimientoControl> getAll(Pageable pageable);
}
