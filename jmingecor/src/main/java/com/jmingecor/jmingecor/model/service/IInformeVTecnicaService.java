package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.InformeVTecnica;

public interface IInformeVTecnicaService {
    public void guardarInformeVTecnica(InformeVTecnica informeVTecnica);
    public List<InformeVTecnica> cargarInformeVTecnica();
    public InformeVTecnica buscarInformeVTecnica(Long id);

    public void eliminarInformeVTecnica(Long id);
    
    Page<InformeVTecnica> getAll(Pageable pageable);

}
