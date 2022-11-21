package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.Almacen;

public interface IAlmacenService {
    public void guardarAlmacen(Almacen almacen);
    public List<Almacen> cargarAlmacenes();
    public Almacen buscarAlmacen(Long id);

    public void eliminarAlmacen(Long id);
    
    Page<Almacen> getAll(Pageable pageable);

}
