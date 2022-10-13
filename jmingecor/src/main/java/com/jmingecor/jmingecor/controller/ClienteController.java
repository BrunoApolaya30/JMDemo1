package com.jmingecor.jmingecor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.jmingecor.jmingecor.model.entity.Cliente;
import com.jmingecor.jmingecor.model.service.IClienteService;

@Controller
public class ClienteController {
    @Autowired
    private IClienteService clienteService;

    public String index(Model model) {
        Cliente objCliente= new Cliente();
        model.addAttribute("cliente", objCliente);
        model.addAttribute("listaClientes", clienteService.cargarClientes());
        return "cliente/main";
    }

    public String update(@PathVariable(value = "id") Long id, Model model) {
        Cliente objCliente = clienteService.buscarCliente(id);
        model.addAttribute("cliente", objCliente);
        model.addAttribute("listaClientes", clienteService.cargarClientes());
        return "cliente/main";
    }

    public String delete(@PathVariable(value = "id") Long id, Model model) {
        clienteService.eliminarCliente(id);
        return "redirect:/cliente/";
    }
    
    public String store(Cliente cliente, Model model) {
        clienteService.guardarCliente(cliente);
        return "redirect:/cliente/";
    }
}
