package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.Material;

public interface IMaterialService {
    public void guardarMaterial(Material material);
    public List<Material> cargarMateriales();
    public Material buscarMaterial(Long id);

    public void eliminarMaterial(Long id);
    
    Page<Material> getAll(Pageable pageable);
}
