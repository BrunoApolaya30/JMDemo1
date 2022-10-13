package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IAlmacenDAO;
import com.jmingecor.jmingecor.model.entity.Almacen;

@Service
public class AlmacenServiceImp implements IAlmacenService {

    @Autowired
    private IAlmacenDAO almacenDAO;

    @Override
    public void guardarAlmacen(Almacen almacen) {
        almacenDAO.save(almacen);
        
    }

    @Override
    public List<Almacen> cargarAlmacenes() {
        return (List<Almacen>) almacenDAO.findAll();
    }

    @Override
    public Almacen buscarAlmacen(Long id) {
        return almacenDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarAlmacen(Long id) {
        almacenDAO.deleteById(id);
    }
    
}
