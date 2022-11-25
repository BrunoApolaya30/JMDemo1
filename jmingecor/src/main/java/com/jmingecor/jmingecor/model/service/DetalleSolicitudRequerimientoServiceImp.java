package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IDetalleSolicitudRequerimientoDAO;
import com.jmingecor.jmingecor.model.entity.DetalleSolicitudRequerimiento;
import com.jmingecor.jmingecor.model.repository.IDetalleSolicitudRequerimientoRepository;

@Service
public class DetalleSolicitudRequerimientoServiceImp implements IDetalleSolicitudRequerimientoService{

    @Autowired
    private IDetalleSolicitudRequerimientoDAO detalleSolicitudRequerimientoDAO;

    @Autowired
    private IDetalleSolicitudRequerimientoRepository detalleSolicitudRequerimientoRepository;

    @Override
    public void guardarDetalleSolicitudRequerimiento(DetalleSolicitudRequerimiento detalleSolicitudRequerimiento) {
        detalleSolicitudRequerimientoDAO.save(detalleSolicitudRequerimiento);
        
    }

    @Override
    public List<DetalleSolicitudRequerimiento> cargarDetalleSolicitudRequerimiento() {
  
        return (List<DetalleSolicitudRequerimiento>) detalleSolicitudRequerimientoDAO.findAll();
    }

    @Override
    public DetalleSolicitudRequerimiento buscarDetalleSolicitudRequerimiento(Long id_dsrequerimiento) {
       
        return detalleSolicitudRequerimientoDAO.findById(id_dsrequerimiento).orElse(null);
    }

    @Override
    public void eliminarDetalleSolicitudRequerimiento(Long id_dsrequerimiento) {
        detalleSolicitudRequerimientoDAO.deleteById(id_dsrequerimiento);
        
    }

    @Override
    public Page<DetalleSolicitudRequerimiento> getAll(Pageable pageable) {
        
        return detalleSolicitudRequerimientoRepository.findAll(pageable);
    } 
}
