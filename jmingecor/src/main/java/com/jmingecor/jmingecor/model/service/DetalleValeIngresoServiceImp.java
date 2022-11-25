package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IDetalleValeIngresoDAO;
import com.jmingecor.jmingecor.model.entity.DetalleValeIngreso;
import com.jmingecor.jmingecor.model.repository.IDetalleValeIngresoRepository;

@Service
public class DetalleValeIngresoServiceImp implements IDetalleValeIngresoService{

    @Autowired
    private IDetalleValeIngresoDAO detalleValeIngresoDAO;

    @Autowired
    private IDetalleValeIngresoRepository detalleValeIngresoRepository;

    @Override
    public void guardarDetalleValeIngreso(DetalleValeIngreso detalleValeIngreso) {
        detalleValeIngresoDAO.save(detalleValeIngreso);
    }

    @Override
    public List<DetalleValeIngreso> cargarDetalleValeIngreso() {
        return (List<DetalleValeIngreso>) detalleValeIngresoDAO.findAll();
    }

    @Override
    public DetalleValeIngreso buscarDetalleValeIngreso(Long id_detalle_ingreso) {
        return detalleValeIngresoDAO.findById(id_detalle_ingreso).orElse(null);
    }

    @Override
    public void eliminarDetalleValeIngreso(Long id_detalle_ingreso) {
        detalleValeIngresoDAO.deleteById(id_detalle_ingreso); 
    }

    @Override
    public Page<DetalleValeIngreso> getAll(Pageable pageable) {
        return detalleValeIngresoRepository.findAll(pageable);
    }
    
}
