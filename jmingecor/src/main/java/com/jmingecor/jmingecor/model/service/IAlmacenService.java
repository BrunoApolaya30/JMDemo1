package com.jmingecor.jmingecor.model.service;

import java.util.List;

import com.jmingecor.jmingecor.model.entity.Almacen;

public interface IAlmacenService {
    public void guardarAlmacen(Almacen almacen);
    public List<Almacen> cargarAlmacenes();
    public Almacen buscarAlmacen(Long id);
    public void eliminarAlmacen(Long id);
}
