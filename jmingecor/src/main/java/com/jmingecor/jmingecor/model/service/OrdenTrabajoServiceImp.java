package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IOrdenTrabajoDAO;
import com.jmingecor.jmingecor.model.entity.OrdenTrabajo;
import com.jmingecor.jmingecor.model.repository.IOrdenTrabajoRepository;

@Service
public class OrdenTrabajoServiceImp implements IOrdenTrabajoService{
    
    @Autowired
    private IOrdenTrabajoDAO ordenTrabajoDAO;

    @Autowired
    private IOrdenTrabajoRepository ordenTrabajoRepository;

    @Override
    public void guardarOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        ordenTrabajoDAO.save(ordenTrabajo);
    }

    @Override
    public List<OrdenTrabajo> cargarOrdenTrabajo() {
        return (List<OrdenTrabajo>) ordenTrabajoDAO.findAll();
    }

    @Override
    public OrdenTrabajo buscarOrdenTrabajo(Long id) {
        return ordenTrabajoDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarOrdenTrabajo(Long id) {
        ordenTrabajoDAO.deleteById(id);
    }

    @Override
    public Page<OrdenTrabajo> getAll(Pageable pageable) {
        return ordenTrabajoRepository.findAll(pageable);
    }


}
