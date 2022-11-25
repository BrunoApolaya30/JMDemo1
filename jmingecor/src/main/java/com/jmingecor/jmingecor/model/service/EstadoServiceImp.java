package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IEstadoDAO;
import com.jmingecor.jmingecor.model.entity.Estado;

@Service
public class EstadoServiceImp implements IEstadoService {

    @Autowired
    private IEstadoDAO estadoDAO;

    @Override
    public void guardarEstado(Estado estado) {
        estadoDAO.save(estado);
    }

    @Override
    public List<Estado> cargarEstados() {
        return (List<Estado>) estadoDAO.findAll();
    }

    @Override
    public Estado buscarEstado(Long id) {
        return estadoDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarEstado(Long id) {
        estadoDAO.deleteById(id);
    }
    
}
