package com.jmingecor.jmingecor.model.service;

import java.util.List;

import com.jmingecor.jmingecor.model.entity.ContactoCampo;

public interface IContactoCampoService  {
    public void guardarContactoCampo(ContactoCampo contactoCampo);
    public List<ContactoCampo> cargarContactosCampo();
    public ContactoCampo buscarContactoCampo(Long id);
    public void eliminarContactoCampo(Long id);
}
