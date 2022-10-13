package com.jmingecor.jmingecor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.jmingecor.jmingecor.model.entity.SeguimientoControl;
import com.jmingecor.jmingecor.model.service.ISeguimientoControlService;

@Controller
public class SeguimientoControlController {
    
    @Autowired
    private ISeguimientoControlService seguimientoControlService;

    
    public String index(Model model) {
        SeguimientoControl objSeguimientoControl = new SeguimientoControl();
        model.addAttribute("seguimientoControl", objSeguimientoControl);
        model.addAttribute("listaSeguimientoControl", seguimientoControlService.cargarSeguimientosControl());
        return "seguimientocontrol/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        SeguimientoControl objSeguimientoControl = seguimientoControlService.buscarSeguimientoControl(id);
        model.addAttribute("seguimientoControl", objSeguimientoControl);
        model.addAttribute("listaSeguimientoControl", seguimientoControlService.cargarSeguimientosControl());
        return "seguimientocontrol/main";
    }

    public String delete(@PathVariable(value = "id") Long id, Model model) {
        seguimientoControlService.eliminarSeguimientoControl(id);
        return "redirect:/seguimientocontrol/";
    }
    
    public String store(SeguimientoControl seguimientoControl, Model model) {
        seguimientoControlService.guardarSeguimientoControl(seguimientoControl);
        return "redirect:/seguimientocontrol/";
    }
}
