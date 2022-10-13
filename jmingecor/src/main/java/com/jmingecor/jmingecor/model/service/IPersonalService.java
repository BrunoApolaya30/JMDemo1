package com.jmingecor.jmingecor.model.service;

import java.util.List;

import com.jmingecor.jmingecor.model.entity.Personal;

public interface IPersonalService {
    public void guardarPersonal(Personal personal);
    public List<Personal> cargarPersonales();
    public Personal buscarPersonal(Long id);
    public void eliminarPersonal(Long id);
}
