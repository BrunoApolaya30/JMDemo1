package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IMaterialDAO;
import com.jmingecor.jmingecor.model.entity.Material;

@Service
public class MaterialServiceImp implements IMaterialService {

    @Autowired
    private IMaterialDAO materialDAO;
    

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
    
}
