package com.jmingecor.jmingecor.model.service;

import java.util.List;

import com.jmingecor.jmingecor.model.entity.CalculoJornal;

public interface ICalculoJornalService {
    public void guardarCalculoJornal(CalculoJornal calculoJornal);
    public List<CalculoJornal> cargarCalculoJornal();
    public CalculoJornal buscarCalculoJornal(Long id);
    public void eliminarCalculoJornal(Long id);
}
