package com.jmingecor.jmingecor.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id_cliente;

    @Column(name = "documento_ruc")
    private String documento_ruc;

    @Column(name = "nombre_completo_rz")
    private String nombre_completo_rz;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_registro")
    private Date fecha_registro;
}
