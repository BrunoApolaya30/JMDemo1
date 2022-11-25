package com.jmingecor.jmingecor.model.service;

import java.util.List;

import com.jmingecor.jmingecor.model.entity.Operaciones;

public interface IOperacionesService {
    public void guardarOperaciones(Operaciones operaciones);
    public List<Operaciones> cargarOperaciones();
    public Operaciones buscarOperaciones(Long id);

    public void eliminarOperaciones(Long id);
    
}
