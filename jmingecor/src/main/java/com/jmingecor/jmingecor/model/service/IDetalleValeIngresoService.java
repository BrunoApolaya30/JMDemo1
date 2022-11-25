package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.DetalleValeIngreso;

public interface IDetalleValeIngresoService {
    public void guardarDetalleValeIngreso(DetalleValeIngreso detalleValeIngreso);
    public List<DetalleValeIngreso> cargarDetalleValeIngreso();
    public DetalleValeIngreso buscarDetalleValeIngreso(Long id_detalle_ingreso);
    public void eliminarDetalleValeIngreso(Long id_detalle_ingreso);

    Page<DetalleValeIngreso> getAll(Pageable pageable);
}
