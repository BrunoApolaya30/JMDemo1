package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmingecor.jmingecor.model.dao.IContactoCampoDAO;
import com.jmingecor.jmingecor.model.entity.ContactoCampo;
import com.jmingecor.jmingecor.model.repository.IContactoCampoRepository;

@Service
public class ContactoCampoServiceImp implements IContactoCampoService {
    
    @Autowired
    private IContactoCampoDAO contactoCampoDAO;

    @Autowired
    private IContactoCampoRepository contactoCampoRepository;

    @Override
    public void guardarContactoCampo(ContactoCampo contactoCampo) {
        contactoCampoDAO.save(contactoCampo);
        
    }

    @Override
    public List<ContactoCampo> cargarContactosCampo() {
        return (List<ContactoCampo>) contactoCampoDAO.findAll();
    }

    @Override
    public ContactoCampo buscarContactoCampo(Long id_contacto_campo) {
        return contactoCampoDAO.findById(id_contacto_campo).orElse(null);
    }

    @Override
    public void eliminarContactoCampo(Long id_contacto_campo) {
        contactoCampoDAO.deleteById(id_contacto_campo);
        
    }

    @Override
    public Page<ContactoCampo> getAll(Pageable pageable) {
        return contactoCampoRepository.findAll(pageable);
    }
}
