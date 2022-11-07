package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.Equipo;

public interface IEquipoService {
    public void guardarEquipo(Equipo equipo);
    public List<Equipo> cargarEquipos();
    public Equipo buscarEquipo(Long id);

    public void eliminarEquipo(Long id);
    
    Page<Equipo> getAll(Pageable pageable);

}
