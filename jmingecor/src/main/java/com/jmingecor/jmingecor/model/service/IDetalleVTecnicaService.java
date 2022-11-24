package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.DetalleVTecnica;

public interface IDetalleVTecnicaService {
    public void guardarDetalleVTecnica(DetalleVTecnica detalleVTecnica);
    public List<DetalleVTecnica> cargarDetalleVTecnica();
    public DetalleVTecnica buscarDetalleVTecnica(Long id);

    public void eliminarDetalleVTecnica(Long id);
    
    Page<DetalleVTecnica> getAll(Pageable pageable);

}
