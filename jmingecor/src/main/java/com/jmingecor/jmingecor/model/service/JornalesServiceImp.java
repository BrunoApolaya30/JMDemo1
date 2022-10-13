package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IJornalesDAO;
import com.jmingecor.jmingecor.model.entity.Jornales;

@Service
public class JornalesServiceImp implements IJornalesService {

    @Autowired
    private IJornalesDAO jornalesDAO;

    @Override
    public void guardarJornales(Jornales jornales) {
        jornalesDAO.save(jornales);     
    }

    @Override
    public List<Jornales> cargarJornales() {
        return (List<Jornales>) jornalesDAO.findAll();
    }

    @Override
    public Jornales buscarJornales(Long id) {
        return jornalesDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarJornales(Long id) {
        jornalesDAO.deleteById(id);
        
    }
    
}
