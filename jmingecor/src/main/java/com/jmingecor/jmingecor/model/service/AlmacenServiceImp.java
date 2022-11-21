package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IAlmacenDAO;
import com.jmingecor.jmingecor.model.entity.Almacen;
import com.jmingecor.jmingecor.model.repository.IAlmacenRepository;

@Service
public class AlmacenServiceImp implements IAlmacenService {

    @Autowired
    private IAlmacenDAO almacenDAO;

    @Autowired
    private IAlmacenRepository almacenRepository;

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


    @Override
    public Page<Almacen> getAll(org.springframework.data.domain.Pageable pageable) {
        return almacenRepository.findAll(pageable);
    }
    
}
