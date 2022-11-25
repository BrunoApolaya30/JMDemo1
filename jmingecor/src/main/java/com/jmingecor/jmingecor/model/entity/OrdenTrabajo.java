package com.jmingecor.jmingecor.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orden_trabajo")
public class OrdenTrabajo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ot")
    private Long id;

    @Column(name = "lugar_trabajo")
    private String lugarTrabajo;

    @Column(name = "correo")
    private String correoOT;

    @Column(name = "telefono")
    private String telefonoOT;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_contacto_campo")
    ContactoCampo contactoCampo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getCorreoOT() {
        return correoOT;
    }

    public void setCorreoOT(String correoOT) {
        this.correoOT = correoOT;
    }

    public String getTelefonoOT() {
        return telefonoOT;
    }

    public void setTelefonoOT(String telefonoOT) {
        this.telefonoOT = telefonoOT;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ContactoCampo getContactoCampo() {
        return contactoCampo;
    }

    public void setContactoCampo(ContactoCampo contactoCampo) {
        this.contactoCampo = contactoCampo;
    }

    
    
}
