package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IEquipoDAO;
import com.jmingecor.jmingecor.model.entity.Equipo;

@Service
public class EquipoServiceImp implements IEquipoService {

    @Autowired
    private IEquipoDAO equipoDAO;

    @Override
    public void guardarEquipo(Equipo equipo) {
        equipoDAO.save(equipo);
    }

    @Override
    public List<Equipo> cargarEquipos() {
        return (List<Equipo>) equipoDAO.findAll();
    }

    @Override
    public Equipo buscarEquipo(Long id) {
        return equipoDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarEquipo(Long id) {
        equipoDAO.deleteById(id);
    }
    
    
}
