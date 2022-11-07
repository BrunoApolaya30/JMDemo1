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
public class Equipo implements Serializable {
    
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_equipo")
     private Long id;

     @ManyToOne
     @JoinColumn(name = "id_categoria")
     Categoria categoria;
    
     public Categoria getCategoria() {
        return categoria;
     }

     public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
     }

    @Column(name = "nombre_equipo")
     private String nombre;

     @Column(name = "descripcion_equipo")
     private String descripcion;

     @Column(name = "fecha_equipo")
     @Temporal(TemporalType.DATE)
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date fecha;

     @Column(name = "cantidad_equipo")
     private int cantidad;
     
     @Column(name = "peso_equipo")
     private double peso;

     @Column(name = "peso_total_equipo")
     private double peso_total;

     @Column(name = "alquiler_equipo")
     private double alquiler;

     @Column(name = "observaciones_equipo")
     private String observaciones;

      public Long getId() {
         return id;
      }

      public void setId(Long id) {
         this.id = id;
      }

      public String getNombre() {
         return nombre;
      }

      public void setNombre(String nombre) {
         this.nombre = nombre;
      }

      public String getDescripcion() {
         return descripcion;
      }

      public void setDescripcion(String descripcion) {
         this.descripcion = descripcion;
      }

      public Date getFecha() {
         return fecha;
      }

      public void setFecha(Date fecha) {
         this.fecha = fecha;
      }

      public int getCantidad() {
         return cantidad;
      }

      public void setCantidad(int cantidad) {
         this.cantidad = cantidad;
      }

      public double getPeso() {
         return peso;
      }

      public void setPeso(double peso) {
         this.peso = peso;
      }

      public double getPeso_total() {
         return peso_total;
      }

      public void setPeso_total(double peso_total) {
         this.peso_total = peso_total;
      }

      public double getAlquiler() {
         return alquiler;
      }

      public void setAlquiler(double alquiler) {
         this.alquiler = alquiler;
      }

      public String getObservaciones() {
         return observaciones;
      }

      public void setObservaciones(String observaciones) {
         this.observaciones = observaciones;
      }
       
}
