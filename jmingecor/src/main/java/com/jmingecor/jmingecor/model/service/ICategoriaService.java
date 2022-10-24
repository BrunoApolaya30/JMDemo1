package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.Categoria;

public interface ICategoriaService {
    public void guardarCategoria(Categoria categoria);
    public List<Categoria> cargarCategoria();
    public Categoria buscarCategoria(Long id);

    public void eliminarCategoria(Long id);

    Page<Categoria> getAll(Pageable pageable);
}
