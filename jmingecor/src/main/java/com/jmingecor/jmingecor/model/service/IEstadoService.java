package com.jmingecor.jmingecor.model.service;

import java.util.List;

import com.jmingecor.jmingecor.model.entity.Estado;

public interface IEstadoService {
    public void guardarEstado(Estado estado);
    public List<Estado> cargarEstados();
    public Estado buscarEstado(Long id);

    public void eliminarEstado(Long id);
    
}
