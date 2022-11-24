package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IPersonalDAO;
import com.jmingecor.jmingecor.model.entity.Personal;
import com.jmingecor.jmingecor.model.repository.IPersonalRepository;

@Service
public class PersonalServiceImp implements IPersonalService {

    @Autowired
    private IPersonalDAO personalDAO;

    @Autowired
    private IPersonalRepository personalRepository;
    
    @Override
    public void guardarPersonal(Personal personal) {
        personalDAO.save(personal);
    }

    @Override
    public List<Personal> cargarPersonales() {
        return (List<Personal>) personalDAO.findAll();
    }

    @Override
    public Personal buscarPersonal(Long id_personal) {
        return personalDAO.findById(id_personal).orElse(null);
    }

    @Override
    public void eliminarPersonal(Long id_personal) {
        personalDAO.deleteById(id_personal);
        
    }

    @Override
    public Page<Personal> getAll(Pageable pageable) {
        return personalRepository.findAll(pageable);
    }
    
}
