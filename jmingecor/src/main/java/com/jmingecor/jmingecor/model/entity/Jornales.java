package com.jmingecor.jmingecor.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jornales")
public class Jornales implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jornal")
    private Long id_jornal;

    @ManyToOne
    @Column(name = "id_categoria")
    Categoria categoria;

    @Column(name = "unidad_jornal")
    private String unidad_jornal;

    @Column(name = "costo_jornal")
    private double costo_jornal;

}
