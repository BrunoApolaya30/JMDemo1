package com.jmingecor.jmingecor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jmingecor.jmingecor.model.entity.Equipo;
import com.jmingecor.jmingecor.model.service.IEquipoService;

@Controller
@RequestMapping("/equipo")
public class EquipoController {
    @Autowired
    private IEquipoService equipoService;
    @RequestMapping("/")
    public String index(Model model) {
        Equipo objEquipo = new Equipo();
        model.addAttribute("equipo", objEquipo);
        model.addAttribute("listaEquipos", equipoService.cargarEquipos());
        return "equipo/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        Equipo objEquipo = equipoService.buscarEquipo(id);
        model.addAttribute("equipo", objEquipo);
        model.addAttribute("listaEquipos", equipoService.cargarEquipos());
        return "equipo/main";
    }

    public String delete(@PathVariable(value = "id") Long id, Model model) {
        equipoService.eliminarEquipo(id);
        return "redirect:/equipo/";
    }
    
    public String store(Equipo equipo, Model model) {
        equipoService.guardarEquipo(equipo);
        return "redirect:/equipo/";
    }
}
