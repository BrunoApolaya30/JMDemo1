package com.jmingecor.jmingecor.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "almacen")
public class Almacen implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_almacen")
    private Long id_almacen;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "descripcion")
    private String descripcion;
}
