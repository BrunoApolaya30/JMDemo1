package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.Usuario;

public interface  IUsuarioRepository extends JpaRepository<Usuario,Long> {
    
}
