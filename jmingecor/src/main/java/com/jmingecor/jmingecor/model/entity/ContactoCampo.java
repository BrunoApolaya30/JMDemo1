package com.jmingecor.jmingecor.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacto_campo")
public class ContactoCampo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto_campo")
    private Long id_contacto_campo;

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "cargo_empresa")
    private String cargo_empresa;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    public Long getId_contacto_campo() {
        return id_contacto_campo;
    }

    public void setId_contacto_campo(Long id_contacto_campo) {
        this.id_contacto_campo = id_contacto_campo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo_empresa() {
        return cargo_empresa;
    }

    public void setCargo_empresa(String cargo_empresa) {
        this.cargo_empresa = cargo_empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


}
