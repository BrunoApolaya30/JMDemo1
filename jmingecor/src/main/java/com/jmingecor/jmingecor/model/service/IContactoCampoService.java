package com.jmingecor.jmingecor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmingecor.jmingecor.model.entity.ContactoCampo;

public interface IContactoCampoService  {
    public void guardarContactoCampo(ContactoCampo contactoCampo);
    public List<ContactoCampo> cargarContactosCampo();
    public ContactoCampo buscarContactoCampo(Long id_contacto_campo);
    public void eliminarContactoCampo(Long id_contacto_campo);
    Page<ContactoCampo> getAll(Pageable pageable);
}
