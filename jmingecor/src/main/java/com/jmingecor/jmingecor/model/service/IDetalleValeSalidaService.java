package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.DetalleValeSalida;

public interface IDetalleValeSalidaService {
    public void guardarDetalleValeSalida(DetalleValeSalida detalleValeSalida);
    public List<DetalleValeSalida> cargarDetalleValeSalida();
    public DetalleValeSalida buscarDetalleValeSalida(Long id_detalle_salida);
    public void eliminarDetalleValeSalida(Long id_detalle_salida);

    Page<DetalleValeSalida> getAll(Pageable pageable);
}
