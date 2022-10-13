package com.jmingecor.jmingecor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.jmingecor.jmingecor.model.entity.Cargo;
import com.jmingecor.jmingecor.model.service.ICargoService;

@Controller
public class CargoController {
    @Autowired
    private ICargoService cargoService;

    
    public String index(Model model) {
        Cargo objCargo = new Cargo();
        model.addAttribute("cargo", objCargo);
        model.addAttribute("listaCargos", cargoService.cargarCargo());
        return "cargo/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        Cargo objCargo = cargoService.buscarCargo(id);
        model.addAttribute("cargo", objCargo);
        model.addAttribute("listaCargos", cargoService.cargarCargo());
        return "cargo/main";
    }

    public String delete(@PathVariable(value = "id") Long id, Model model) {
        cargoService.eliminarCargo(id);
        return "redirect:/cargo/";
    }
    
    public String store(Cargo cargo, Model model) {
        cargoService.guardarCargo(cargo);
        return "redirect:/cargo/";
    }
}
