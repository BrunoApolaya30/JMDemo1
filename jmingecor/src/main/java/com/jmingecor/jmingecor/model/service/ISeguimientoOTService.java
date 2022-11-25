package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.SeguimientoOT;

public interface ISeguimientoOTService {
    public void guardarSeguimientoOT(SeguimientoOT seguimientoOT);
    public List<SeguimientoOT> cargarSeguimientoOT();
    public SeguimientoOT buscarSeguimientoOT(Long id_seguimiento_ot);

    public void eliminarSeguimientoOT(Long id_seguimiento_ot);
    
    Page<SeguimientoOT> getAll(Pageable pageable);
}
