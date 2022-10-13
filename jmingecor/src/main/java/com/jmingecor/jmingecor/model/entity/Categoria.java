package com.jmingecor.jmingecor.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id_categoria;

    @Column(name = "nombre_categoria")
    private String nombre_categoria;

    @Column(name = "descripcion_categoria")
    private String descripcion_categoria;
}
