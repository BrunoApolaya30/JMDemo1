package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.Usuario;

public interface IUsuarioService {
    public void guardarUsuario(Usuario usuario);
    public List<Usuario> cargarUsuarios();
    public Usuario buscarUsuario(Long id_usuario);
    public void eliminarUsuario(Long id_usuario);

    Page<Usuario> getAll(Pageable pageable);
}
