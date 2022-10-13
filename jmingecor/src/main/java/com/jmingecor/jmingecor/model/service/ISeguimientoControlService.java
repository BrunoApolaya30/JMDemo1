package com.jmingecor.jmingecor.model.service;

import java.util.List;

import com.jmingecor.jmingecor.model.entity.SeguimientoControl;

public interface ISeguimientoControlService {
    public void guardarSeguimientoControl(SeguimientoControl seguimientoControl);
    public List<SeguimientoControl> cargarSeguimientosControl();
    public SeguimientoControl buscarSeguimientoControl(Long id);
    public void eliminarSeguimientoControl(Long id);
}
