package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.SolicitudRequerimiento;

public interface ISolicitudRequerimientoService {
    public void guardarSolicitudRequerimiento(SolicitudRequerimiento solicitudRequerimiento);
    public List<SolicitudRequerimiento> cargarSolicitudRequerimiento();
    public SolicitudRequerimiento buscarSolicitudRequerimiento(Long id_solicitudr);
    public void eliminarSolicitudRequerimiento(Long id_solicitudr);

    Page<SolicitudRequerimiento> getAll(Pageable pageable);
}
