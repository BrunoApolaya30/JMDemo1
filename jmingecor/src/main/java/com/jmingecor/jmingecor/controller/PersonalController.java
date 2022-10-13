package com.jmingecor.jmingecor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.jmingecor.jmingecor.model.entity.Personal;
import com.jmingecor.jmingecor.model.service.IPersonalService;

@Controller
public class PersonalController {

    @Autowired
    private IPersonalService personalService;

    
    public String index(Model model) {
        Personal objPersonal = new Personal();
        model.addAttribute("personal", objPersonal);
        model.addAttribute("listaPersonal", personalService.cargarPersonales());
        return "personal/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        Personal objPersonal = personalService.buscarPersonal(id);
        model.addAttribute("personal", objPersonal);
        model.addAttribute("listaPersonal", personalService.cargarPersonales());
        return "personal/main";
    }

    public String delete(@PathVariable(value = "id") Long id, Model model) {
        personalService.eliminarPersonal(id);
        return "redirect:/personal/";
    }
    
    public String store(Personal personal, Model model) {
        personalService.guardarPersonal(personal);
        return "redirect:/personal/";
    }
}
