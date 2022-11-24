package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.ValeSalida;

public interface  IValeSalidaService {
    public void guardarValeSalida(ValeSalida valeSalida);
    public List<ValeSalida> cargarValeSalida();
    public ValeSalida buscarValeSalida(Long id_salida);
    public void eliminarValeSalida(Long id_salida);
    
    Page<ValeSalida> getAll(Pageable pageable);
}
