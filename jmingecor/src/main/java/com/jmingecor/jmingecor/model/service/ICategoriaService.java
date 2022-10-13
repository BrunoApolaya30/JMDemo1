package com.jmingecor.jmingecor.model.service;

import java.util.List;

import com.jmingecor.jmingecor.model.entity.Categoria;

public interface ICategoriaService {
    public void guardarCategoria(Categoria categoria);
    public List<Categoria> cargarCategoria();
    public Categoria buscarCategoria(Long id);
    public void eliminarCategoria(Long id);
}
