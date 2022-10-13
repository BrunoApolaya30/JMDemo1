package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IContactoCampoDAO;
import com.jmingecor.jmingecor.model.entity.ContactoCampo;

@Service
public class ContactoCampoServiceImp implements IContactoCampoService {
    
    @Autowired
    private IContactoCampoDAO contactoCampoDAO;

    @Override
    public void guardarContactoCampo(ContactoCampo contactoCampo) {
        contactoCampoDAO.save(contactoCampo);
        
    }

    @Override
    public List<ContactoCampo> cargarContactosCampo() {
        return (List<ContactoCampo>) contactoCampoDAO.findAll();
    }

    @Override
    public ContactoCampo buscarContactoCampo(Long id) {
        return contactoCampoDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarContactoCampo(Long id) {
        contactoCampoDAO.deleteById(id);
        
    }
}
