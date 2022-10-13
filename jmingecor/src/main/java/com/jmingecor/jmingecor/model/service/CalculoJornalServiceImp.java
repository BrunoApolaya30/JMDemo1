package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.ICalculoJornalDAO;
import com.jmingecor.jmingecor.model.entity.CalculoJornal;

@Service
public class CalculoJornalServiceImp implements ICalculoJornalService {

    @Autowired
    private ICalculoJornalDAO calculoJornalDAO;
    
    @Override
    public void guardarCalculoJornal(CalculoJornal calculoJornal) {
        calculoJornalDAO.save(calculoJornal);
    }

    @Override
    public List<CalculoJornal> cargarCalculoJornal() {
        return (List<CalculoJornal>) calculoJornalDAO.findAll();
    }
    @Override
    public CalculoJornal buscarCalculoJornal(Long id) {
        return calculoJornalDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarCalculoJornal(Long id) {
       calculoJornalDAO.deleteById(id);
    }
    
}
