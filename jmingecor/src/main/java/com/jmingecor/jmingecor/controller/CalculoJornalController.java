package com.jmingecor.jmingecor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.jmingecor.jmingecor.model.entity.CalculoJornal;
import com.jmingecor.jmingecor.model.service.ICalculoJornalService;

@Controller
public class CalculoJornalController {
    @Autowired
    private ICalculoJornalService calculoJornalService;

     public String index(Model model) {
        CalculoJornal objCalculoJornal = new CalculoJornal();
        model.addAttribute("calculoJornal", objCalculoJornal);
        model.addAttribute("listaCalculosJornal", calculoJornalService.cargarCalculoJornal());
        return "calculojornal/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        CalculoJornal objCalculoJornal = calculoJornalService.buscarCalculoJornal(id);
        model.addAttribute("calculoJornal", objCalculoJornal);
        model.addAttribute("listaCalculosJornal", calculoJornalService.cargarCalculoJornal());
        return "calculojornal/main";
    }

    public String delete(@PathVariable(value = "id") Long id, Model model) {
        calculoJornalService.eliminarCalculoJornal(id);
        return "redirect:/calculojornal/";
    }
    
    public String store(CalculoJornal calculoJornal, Model model) {

        calculoJornalService.guardarCalculoJornal(calculoJornal);
        return "redirect:/calculojornal/";
        }
}
