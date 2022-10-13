package com.jmingecor.jmingecor.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "seguimiento_control")
public class SeguimientoControl implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_control")
    private Long id_control;

    @ManyToOne
    @Column(name = "id_categoria")
    Categoria categoria;

    @ManyToOne
    @Column(name = "id_almacen")
    Almacen almacen;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "sku")
    private double sku;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "unidad")
    private String unidad;

    @Column(name = "estado")
    private String estado;

    @Column(name = "responsable")
    private String responsable;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_registro")
    private Date fecha_registro;
}
