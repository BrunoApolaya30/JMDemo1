package com.jmingecor.jmingecor.model.service;

import java.util.List;

import com.jmingecor.jmingecor.model.entity.Jornales;

public interface IJornalesService {
    public void guardarJornales(Jornales jornales);
    public List<Jornales> cargarJornales();
    public Jornales buscarJornales(Long id);
    public void eliminarJornales(Long id);
}
