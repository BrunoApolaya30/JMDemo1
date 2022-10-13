package com.jmingecor.jmingecor.model.service;

import java.util.List;

import com.jmingecor.jmingecor.model.entity.Usuario;

public interface IUsuarioService {
    public void guardarUsuario(Usuario usuario);
    public List<Usuario> cargarUsuarios();
    public Usuario buscarUsuario(Long id);
    public void eliminarUsuario(Long id);
}
