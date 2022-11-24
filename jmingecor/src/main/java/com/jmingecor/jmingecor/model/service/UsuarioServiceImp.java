package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IUsuarioDAO;
import com.jmingecor.jmingecor.model.entity.Usuario;
import com.jmingecor.jmingecor.model.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImp implements IUsuarioService {

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioDAO.save(usuario);
        
    }

    @Override
    public List<Usuario> cargarUsuarios() {
        return (List<Usuario>) usuarioDAO.findAll();
    }

    @Override
    public Usuario buscarUsuario(Long id_usuario) {
        return usuarioDAO.findById(id_usuario).orElse(null);
    }

    @Override
    public void eliminarUsuario(Long id_usuario) {
        usuarioDAO.deleteById(id_usuario);
        
    }

    @Override
    public Page<Usuario> getAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }
    
}
