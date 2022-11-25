package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.DatosServicioOT;

public interface IDatosServicioOTService {
    public void guardarDatosServicioOT(DatosServicioOT datosServicioOT);
    public List<DatosServicioOT> cargarDatosServicioOT();
    public DatosServicioOT buscarDatosServicioOT(Long id);

    public void eliminarDatosServicioOT(Long id);
    
    Page<DatosServicioOT> getAll(Pageable pageable);
}
