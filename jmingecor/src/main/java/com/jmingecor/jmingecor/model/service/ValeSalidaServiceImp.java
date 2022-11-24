package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IValeSalidaDAO;
import com.jmingecor.jmingecor.model.entity.ValeSalida;
import com.jmingecor.jmingecor.model.repository.IValeSalidaRepository;

@Service
public class ValeSalidaServiceImp implements IValeSalidaService {
    
    @Autowired
    private IValeSalidaDAO valeSalidaDAO;

    @Autowired
    private IValeSalidaRepository valeSalidaRepository;

    @Override
    public void guardarValeSalida(ValeSalida valeSalida) {
        valeSalidaDAO.save(valeSalida);
    }

    @Override
    public List<ValeSalida> cargarValeSalida() {
        return (List<ValeSalida>) valeSalidaDAO.findAll();
    }

    @Override
    public ValeSalida buscarValeSalida(Long id_salida) {
        return valeSalidaDAO.findById(id_salida).orElse(null);
    }

    @Override
    public void eliminarValeSalida(Long id_salida) {
        valeSalidaDAO.deleteById(id_salida);
    }

    @Override
    public Page<ValeSalida> getAll(Pageable pageable) {
        return valeSalidaRepository.findAll(pageable);
    }
}
