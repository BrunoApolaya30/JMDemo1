package com.jmingecor.jmingecor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.jmingecor.jmingecor.model.entity.ContactoCampo;
import com.jmingecor.jmingecor.model.service.IContactoCampoService;

@Controller
public class ContactoCampoController {
    @Autowired
    private IContactoCampoService contactoCampoService;

    
    public String index(Model model) {
        ContactoCampo objContactoCampo = new ContactoCampo();
        model.addAttribute("contactoCampo", objContactoCampo);
        model.addAttribute("listaContactosCampo", contactoCampoService.cargarContactosCampo());
        return "contactocampo/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        ContactoCampo objContactoCampo = contactoCampoService.buscarContactoCampo(id);
        model.addAttribute("contactoCampo", objContactoCampo);
        model.addAttribute("listaContactosCampo", contactoCampoService.cargarContactosCampo());
        return "contactocampo/main";
    }

    public String delete(@PathVariable(value = "id") Long id, Model model) {
        contactoCampoService.eliminarContactoCampo(id);
        return "redirect:/contactocampo/";
    }
    
    public String store(ContactoCampo contactoCampo, Model model) {
        contactoCampoService.guardarContactoCampo(contactoCampo);
        return "redirect:/contactocampo/";
    }
}
