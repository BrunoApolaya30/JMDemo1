package com.jmingecor.jmingecor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.jmingecor.jmingecor.model.entity.Almacen;
import com.jmingecor.jmingecor.model.service.IAlmacenService;

@Controller
public class AlmacenController {
    
    @Autowired
    private IAlmacenService almacenService;

    public String index(Model model) {
        Almacen objAlmacen = new Almacen();
        model.addAttribute("almacen", objAlmacen);
        model.addAttribute("listaAlmacenes", almacenService.cargarAlmacenes());
        return "almacen/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        Almacen objAlmacen = almacenService.buscarAlmacen(id);
        model.addAttribute("almacen", objAlmacen);
        model.addAttribute("listaAlmacenes", almacenService.cargarAlmacenes());
        return "almacen/main";
    }

    public String delete(@PathVariable(value = "id") Long id, Model model) {
        almacenService.eliminarAlmacen(id);
        return "redirect:/almacen/";
    }

    public String store(Almacen almacen, Model model) {
        almacenService.guardarAlmacen(almacen);
        return "redirect:/almacen/";
    }
}
