package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IDetalleSolicitudCompraDAO;
import com.jmingecor.jmingecor.model.entity.DetalleSolicitudCompra;
import com.jmingecor.jmingecor.model.repository.IDetalleSolicitudCompraRepository;

@Service
public class IDetalleSolicitudCompraImp implements IDetalleSolicitudCompraService{
    
    @Autowired
    private IDetalleSolicitudCompraDAO detalleSolicitudCompraDAO;

    @Autowired
    private IDetalleSolicitudCompraRepository detalleSolicitudCompraRepository;

    @Override
    public void guardarDetalleSolicitudCompra(DetalleSolicitudCompra solicitudCompra){
        detalleSolicitudCompraDAO.save(solicitudCompra);
    }

    @Override
    public List<DetalleSolicitudCompra> cargarDetalleSolicitudCompra() {
        return (List<DetalleSolicitudCompra>) detalleSolicitudCompraDAO.findAll();
    }

    @Override
    public DetalleSolicitudCompra buscarDetalleSolicitudCompra(Long iddetalle_scompra) {
        return detalleSolicitudCompraDAO.findById(iddetalle_scompra).orElse(null);
    }

    @Override
    public void eliminarDetalleSolicitudCompra(Long iddetalle_scompra) {
        detalleSolicitudCompraDAO.deleteById(iddetalle_scompra);
    }

    @Override
    public Page<DetalleSolicitudCompra> getAll(Pageable pageable) {
        return detalleSolicitudCompraRepository.findAll(pageable);
    }
}
