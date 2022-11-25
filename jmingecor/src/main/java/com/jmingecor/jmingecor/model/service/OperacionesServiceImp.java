package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IOperacionesDAO;
import com.jmingecor.jmingecor.model.entity.Operaciones;

@Service
public class OperacionesServiceImp implements IOperacionesService{

    @Autowired
    private IOperacionesDAO operacionesDAO;

    @Override
    public void guardarOperaciones(Operaciones operaciones) {
        operacionesDAO.save(operaciones);
    }

    @Override
    public List<Operaciones> cargarOperaciones() {
        return (List<Operaciones>) operacionesDAO.findAll();
    }

    @Override
    public Operaciones buscarOperaciones(Long id) {
        return operacionesDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarOperaciones(Long id) {
        operacionesDAO.deleteById(id);
    }
    
}
