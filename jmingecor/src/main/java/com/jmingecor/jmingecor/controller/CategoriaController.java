package com.jmingecor.jmingecor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.jmingecor.jmingecor.model.entity.Categoria;
import com.jmingecor.jmingecor.model.service.ICategoriaService;

@Controller
public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;

    
    public String index(Model model) {
        Categoria objCategoria = new Categoria();
        model.addAttribute("categoria", objCategoria);
        model.addAttribute("listaCategorias", categoriaService.cargarCategoria());
        return "categoria/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        Categoria objCategoria= categoriaService.buscarCategoria(id);
        model.addAttribute("categoria", objCategoria);
        model.addAttribute("listaCategorias", categoriaService.cargarCategoria());
        return "categoria/main";
    }

    public String delete(@PathVariable(value = "id") Long id, Model model) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/categoria/";
    }
    
    public String store(Categoria categoria, Model model) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categoria/";
    }
}
