package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.dao.IDatosServicioOTDAO;
import com.jmingecor.jmingecor.model.entity.DatosServicioOT;
import com.jmingecor.jmingecor.model.repository.IDatosServicioOTRepository;

public class DatosServicioOTServiceImp implements IDatosServicioOTService{

    @Autowired
    private IDatosServicioOTDAO datosServicioOTDAO;


    @Autowired
    private IDatosServicioOTRepository datosServicioOTRepository;

    @Override
    public void guardarDatosServicioOT(DatosServicioOT datosServicioOT) {
        datosServicioOTDAO.save(datosServicioOT);
    }

    @Override
    public List<DatosServicioOT> cargarDatosServicioOT() {
        return (List<DatosServicioOT>) datosServicioOTDAO.findAll();
    }

    @Override
    public DatosServicioOT buscarDatosServicioOT(Long id) {
        return datosServicioOTDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarDatosServicioOT(Long id) {
        datosServicioOTDAO.deleteById(id);
    }

    @Override
    public Page<DatosServicioOT> getAll(Pageable pageable) {
        return datosServicioOTRepository.findAll(pageable);
    }
    
}
