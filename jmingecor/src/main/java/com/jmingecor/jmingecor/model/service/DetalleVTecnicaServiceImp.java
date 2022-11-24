package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IDetalleVTecnicaDAO;
import com.jmingecor.jmingecor.model.entity.DetalleVTecnica;
import com.jmingecor.jmingecor.model.repository.IDetalleVTecnicaRepository;

@Service
public class DetalleVTecnicaServiceImp implements IDetalleVTecnicaService {

    @Autowired
    private IDetalleVTecnicaDAO detalleVTecnicaDAO;


    @Autowired
    private IDetalleVTecnicaRepository detalleVTecnicaRepository;


    @Override
    public void guardarDetalleVTecnica(DetalleVTecnica detalleVTecnica) {
        detalleVTecnicaDAO.save(detalleVTecnica);
    }

    @Override
    public List<DetalleVTecnica> cargarDetalleVTecnica() {
        return (List<DetalleVTecnica>) detalleVTecnicaDAO.findAll();
    }

    @Override
    public DetalleVTecnica buscarDetalleVTecnica(Long id) {
        return detalleVTecnicaDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarDetalleVTecnica(Long id) {
        detalleVTecnicaDAO.deleteById(id);
    }

    @Override
    public Page<DetalleVTecnica> getAll(Pageable pageable) {
        return detalleVTecnicaRepository.findAll(pageable);
    }
    
    
}
