package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.ValeIngreso;

public interface  IValeIngresoService {
    public void guardarValeIngreso(ValeIngreso valeIngreso);
    public List<ValeIngreso> cargarValeIngreso();
    public ValeIngreso buscarValeIngreso(Long id_ingreso);
    public void eliminarValeIngreso(Long id_ingreso);

    Page<ValeIngreso> getAll(Pageable pageable);
}
