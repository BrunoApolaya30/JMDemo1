package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.DetalleSolicitudCompra;

public interface IDetalleSolicitudCompraService {
    public void guardarDetalleSolicitudCompra(DetalleSolicitudCompra detalleSolicitudCompra);
    public List<DetalleSolicitudCompra> cargarDetalleSolicitudCompra();
    public DetalleSolicitudCompra buscarDetalleSolicitudCompra(Long iddetalle_scompra);
    public void eliminarDetalleSolicitudCompra(Long iddetalle_scompra);

    Page<DetalleSolicitudCompra> getAll(Pageable pageable);
}
