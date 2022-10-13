package com.jmingecor.jmingecor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.jmingecor.jmingecor.model.entity.Usuario;
import com.jmingecor.jmingecor.model.service.IUsuarioService;

@Controller
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;

    public String index(Model model) {
        Usuario objUsuario = new Usuario();
        model.addAttribute("usuario", objUsuario);
        model.addAttribute("listaUsuarios", usuarioService.cargarUsuarios());
        return "usuario/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        Usuario objUsuario = usuarioService.buscarUsuario(id);
        model.addAttribute("usuario", objUsuario);
        model.addAttribute("listaUsuarios", usuarioService.cargarUsuarios());
        return "usuario/main";
    }

    public String delete(@PathVariable(value = "id") Long id, Model model) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuario/";
    }
    
    public String store(Usuario usuario, Model model) {
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuario/";
    }
    

}
