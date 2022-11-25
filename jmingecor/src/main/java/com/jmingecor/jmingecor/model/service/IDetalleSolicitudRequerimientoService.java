package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.DetalleSolicitudRequerimiento;

public interface IDetalleSolicitudRequerimientoService {
    public void guardarDetalleSolicitudRequerimiento(DetalleSolicitudRequerimiento detalleSolicitudRequerimiento);
    public List<DetalleSolicitudRequerimiento> cargarDetalleSolicitudRequerimiento();
    public DetalleSolicitudRequerimiento buscarDetalleSolicitudRequerimiento(Long id_dsrequerimiento);
    public void eliminarDetalleSolicitudRequerimiento(Long id_dsrequerimiento);

    Page<DetalleSolicitudRequerimiento> getAll(Pageable pageable);
}
