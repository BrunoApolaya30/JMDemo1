package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IUsuarioDAO;
import com.jmingecor.jmingecor.model.entity.Usuario;

@Service
public class UsuarioServiceImp implements IUsuarioService {

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioDAO.save(usuario);
        
    }

    @Override
    public List<Usuario> cargarUsuarios() {
        return (List<Usuario>) usuarioDAO.findAll();
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        return usuarioDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioDAO.deleteById(id);
        
    }
    
}
