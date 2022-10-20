package com.jmingecor.jmingecor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jmingecor.jmingecor.model.entity.Material;
import com.jmingecor.jmingecor.model.service.IMaterialService;

@Controller
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private IMaterialService materialService;
    @RequestMapping("/")
    public String index(Model model) {
        Material objMaterial = new Material();
        model.addAttribute("material", objMaterial);
        model.addAttribute("listaMateriales", materialService.cargarMateriales());
        return "material/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        Material objMaterial = materialService.buscarMaterial(id);
        model.addAttribute("material", objMaterial);
        model.addAttribute("listaMateriales", materialService.cargarMateriales());
        return "material/main";
    }

    public String delete(@PathVariable(value = "id") Long id, Model model) {
        materialService.eliminarMaterial(id);
        return "redirect:/material/";
    }
    
    public String store(Material material, Model model) {
        materialService.guardarMaterial(material);
        return "redirect:/material/";
    }
}
