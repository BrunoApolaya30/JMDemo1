package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.ICargoDAO;
import com.jmingecor.jmingecor.model.entity.Cargo;

@Service
public class CargoServiceImp implements ICargoService {


    @Autowired
    private ICargoDAO cargoDAO;

    @Override
    public void guardarCargo(Cargo cargo) {
        cargoDAO.findAll();
        
    }

    @Override
    public List<Cargo> cargarCargo() {
        return (List<Cargo>) cargoDAO.findAll();
    }

    @Override
    public Cargo buscarCargo(Long id) {
        return cargoDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarCargo(Long id) {
        cargoDAO.deleteById(id);
    }
    
}
