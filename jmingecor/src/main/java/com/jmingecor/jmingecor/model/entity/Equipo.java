package com.jmingecor.jmingecor.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="equipos")
public class Equipo implements Serializable{
    /*
     usuario, cliente, personal, cargo y contactoCampo
     */

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_equipo")
     private Long id_equipo;

     @ManyToOne
     @JoinColumn(name = "id_categoria")
     Categoria categoria;

     @Column(name = "nombre_equipo")
     private String nombre_equipo;

     @Column(name = "descripcion_equipo")
     private String descripcion_equipo;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_equipo")
     private Date fecha_equipo;

     @Column(name = "cantidad_equipo")
     private int cantidad_equipo;
     
     @Column(name = "peso_equipo")
     private double peso_equipo;

     @Column(name = "peso_total_equipo")
     private double peso_total_equipo;

     @Column(name = "alquiler_equipo")
     private double alquiler_equipo;

     @Column(name = "observaciones_equipo")
     private String observaciones_equipo;
     

    
}
