package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IClienteDAO;
import com.jmingecor.jmingecor.model.entity.Cliente;

@Service
public class ClienteServiceImp implements IClienteService {
    
    @Autowired
    private IClienteDAO clienteDAO;

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteDAO.save(cliente);
    }

    @Override
    public List<Cliente> cargarClientes() {
        return (List<Cliente>) clienteDAO.findAll();
    }

    @Override
    public Cliente buscarCliente(Long id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarCliente(Long id) {
       clienteDAO.deleteById(id);
        
    }


}
