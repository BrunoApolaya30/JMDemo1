package com.jmingecor.jmingecor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jmingecor.jmingecor.model.entity.Jornales;
import com.jmingecor.jmingecor.model.service.IJornalesService;

@Controller
@RequestMapping("/jornales")
public class JornalesController {
    @Autowired
    private IJornalesService jornalesService;

    @RequestMapping("/")
    public String index(Model model) {
        Jornales objJornales = new Jornales();
        model.addAttribute("jornales", objJornales);
        model.addAttribute("listaJornales", jornalesService.cargarJornales());
        return "jornales/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        Jornales objJornales = jornalesService.buscarJornales(id);
        model.addAttribute("jornales", objJornales);
        model.addAttribute("listaJornales", jornalesService.cargarJornales());
        return "jornales/main";
    }

    public String delete(@PathVariable(value = "id") Long id, Model model) {
        jornalesService.eliminarJornales(id);
        return "redirect:/jornales/";
    }
    
    public String store(Jornales jornales, Model model) {
        jornalesService.guardarJornales(jornales);
        return "redirect:/jornales/";
    }
}
