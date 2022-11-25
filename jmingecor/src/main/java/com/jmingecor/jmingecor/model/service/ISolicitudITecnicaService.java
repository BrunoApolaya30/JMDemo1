package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.SolicitudITecnica;

public interface ISolicitudITecnicaService {
    public void guardarSolicitudITecnica(SolicitudITecnica solicitudITecnica);
    public List<SolicitudITecnica> cargarSolicitudITecnica();
    public SolicitudITecnica buscarSolicitudITecnica(Long id_solicitudit);
    public void eliminarSolicitudITecnica(Long id_solicitudit);

    Page<SolicitudITecnica> getAll(Pageable pageable);
}
