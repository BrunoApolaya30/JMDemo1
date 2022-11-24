package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IInformeVTecnicaDAO;
import com.jmingecor.jmingecor.model.entity.InformeVTecnica;
import com.jmingecor.jmingecor.model.repository.IInformeVTecnicaRepository;

@Service
public class InformeVTecnicaServiceImp implements IInformeVTecnicaService {

    @Autowired
    private IInformeVTecnicaDAO informeVTecnicaDAO;


    @Autowired
    private IInformeVTecnicaRepository informeVTecnicaRepository;


    @Override
    public void guardarInformeVTecnica(InformeVTecnica informeVTecnica) {
        informeVTecnicaDAO.save(informeVTecnica);
    }

    @Override
    public List<InformeVTecnica> cargarInformeVTecnica() {
        return (List<InformeVTecnica>) informeVTecnicaDAO.findAll();
    }

    @Override
    public InformeVTecnica buscarInformeVTecnica(Long id) {
        return informeVTecnicaDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarInformeVTecnica(Long id) {
        informeVTecnicaDAO.deleteById(id);
    }

    @Override
    public Page<InformeVTecnica> getAll(Pageable pageable) {
        return informeVTecnicaRepository.findAll(pageable);
    }
    
    
}
