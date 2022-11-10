package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IMaterialDAO;
import com.jmingecor.jmingecor.model.entity.Material;
import com.jmingecor.jmingecor.model.repository.IMaterialRepository;

@Service
public class MaterialServiceImp implements IMaterialService {

    @Autowired
    private IMaterialDAO materialDAO;
    
    @Autowired
    private IMaterialRepository  materialRepository;

    @Override
    public void guardarMaterial(Material material) {
        materialDAO.save(material);
        
    }

    @Override
    public List<Material> cargarMateriales() {
        return (List<Material>) materialDAO.findAll();
    }

    @Override
    public Material buscarMaterial(Long id) {
        return materialDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarMaterial(Long id) {
        materialDAO.deleteById(id);
        
    }

    @Override
    public Page<Material> getAll(Pageable pageable) {
        return materialRepository.findAll(pageable);
    }
    
}
