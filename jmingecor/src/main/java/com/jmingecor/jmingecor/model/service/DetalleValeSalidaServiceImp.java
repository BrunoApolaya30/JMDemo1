package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IDetalleValeSalidaDAO;
import com.jmingecor.jmingecor.model.entity.DetalleValeSalida;
import com.jmingecor.jmingecor.model.repository.IDetalleValeSalidaRepository;

@Service
public class DetalleValeSalidaServiceImp implements IDetalleValeSalidaService{

    @Autowired
    private IDetalleValeSalidaDAO detalleValeSalidaDAO;

    @Autowired
    private IDetalleValeSalidaRepository detalleValeSalidaRepository;

    @Override
    public void guardarDetalleValeSalida(DetalleValeSalida detalleValeSalida) {
     
        detalleValeSalidaDAO.save(detalleValeSalida);
    }

    @Override
    public List<DetalleValeSalida> cargarDetalleValeSalida() {
    
        return (List<DetalleValeSalida>) detalleValeSalidaDAO.findAll();
    }

    @Override
    public DetalleValeSalida buscarDetalleValeSalida(Long id_detalle_salida) {
        
        return detalleValeSalidaDAO.findById(id_detalle_salida).orElse(null);
    }

    @Override
    public void eliminarDetalleValeSalida(Long id_detalle_salida) {
        
        detalleValeSalidaDAO.deleteById(id_detalle_salida);
    }

    @Override
    public Page<DetalleValeSalida> getAll(Pageable pageable) {
        
        return detalleValeSalidaRepository.findAll(pageable);
    }
    
}
