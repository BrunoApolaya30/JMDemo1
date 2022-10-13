package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IPersonalDAO;
import com.jmingecor.jmingecor.model.entity.Personal;

@Service
public class PersonalServiceImp implements IPersonalService {

    @Autowired
    private IPersonalDAO personalDAO;
    
    @Override
    public void guardarPersonal(Personal personal) {
        personalDAO.save(personal);
    }

    @Override
    public List<Personal> cargarPersonales() {
        return (List<Personal>) personalDAO.findAll();
    }

    @Override
    public Personal buscarPersonal(Long id) {
        return personalDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarPersonal(Long id) {
        personalDAO.deleteById(id);
        
    }
    
}
