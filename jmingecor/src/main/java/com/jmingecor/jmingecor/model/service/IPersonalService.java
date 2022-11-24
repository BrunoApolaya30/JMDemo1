package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.Personal;

public interface IPersonalService {
    public void guardarPersonal(Personal personal);
    public List<Personal> cargarPersonales();
    public Personal buscarPersonal(Long id_personal);
    public void eliminarPersonal(Long id_personal);
    Page<Personal> getAll(Pageable pageable);
}
