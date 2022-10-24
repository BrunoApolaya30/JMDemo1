package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.ICategoriaDAO;
import com.jmingecor.jmingecor.model.entity.Categoria;
import com.jmingecor.jmingecor.model.repository.ICategoriaRepository;

@Service
public class CategoriaServiceImp implements ICategoriaService {

    @Autowired
    private ICategoriaDAO categoriaDAO;


    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    public void guardarCategoria(Categoria categoria) {
        categoriaDAO.save(categoria);
        
    }

    @Override
    public List<Categoria> cargarCategoria() {
        return (List<Categoria>) categoriaDAO.findAll();
    }

    @Override
    public Categoria buscarCategoria(Long id) {
        return categoriaDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaDAO.deleteById(id);

    }

    @Override
    public Page<Categoria> getAll(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }
    
    
}
