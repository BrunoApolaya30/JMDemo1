package com.jmingecor.jmingecor.model.service;

import java.util.List;

import com.jmingecor.jmingecor.model.entity.Cargo;

public interface ICargoService {
    public void guardarCargo(Cargo cargo);
    public List<Cargo> cargarCargo();
    public Cargo buscarCargo(Long id);
    public void eliminarCargo(Long id);
}
