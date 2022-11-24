package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IValeIngresoDAO;
import com.jmingecor.jmingecor.model.entity.ValeIngreso;
import com.jmingecor.jmingecor.model.repository.IValeIngresoRepository;

@Service
public class ValeIngresoServiceImp implements IValeIngresoService {

    @Autowired
    private IValeIngresoDAO valeIngresoDAO;

    @Autowired
    private IValeIngresoRepository valeIngresoRepository;

    @Override
    public void guardarValeIngreso(ValeIngreso valeIngreso){
        valeIngresoDAO.save(valeIngreso);
    }

    @Override
    public List<ValeIngreso> cargarValeIngreso() {
        return (List<ValeIngreso>) valeIngresoDAO.findAll();
    }

    @Override
    public ValeIngreso buscarValeIngreso(Long id_ingreso) {
        return valeIngresoDAO.findById(id_ingreso).orElse(null);
    }

    @Override
    public void eliminarValeIngreso(Long id_ingreso) {
        valeIngresoDAO.deleteById(id_ingreso);
    }

    @Override
    public Page<ValeIngreso> getAll(Pageable pageable) {
        return valeIngresoRepository.findAll(pageable);
    }
    
}
