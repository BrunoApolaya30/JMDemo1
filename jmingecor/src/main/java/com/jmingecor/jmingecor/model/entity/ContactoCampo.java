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
}
