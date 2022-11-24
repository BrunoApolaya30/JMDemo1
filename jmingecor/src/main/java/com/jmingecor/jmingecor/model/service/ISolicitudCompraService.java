package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.SolicitudCompra;

public interface  ISolicitudCompraService {
    public void guardarSolicitudCompra(SolicitudCompra solicitudCompra);
    public List<SolicitudCompra> cargarSolicitudCompra();
    public SolicitudCompra buscarSolicitudCompra(Long id_scompra);
    public void eliminarSolicitudCompra(Long id_scompra);

    Page<SolicitudCompra> getAll(Pageable pageable);
}
