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
@Table(name = "detalleValeIngreso")
public class DetalleValeIngreso implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_ingreso")
    private Long id_detalle_ingreso;

    @Column(name = "sku")
    private String sku;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "unidad")
    private String unidad;

    @Column(name = "observacion")
    private String observacion;

    @ManyToOne
    @Column(name = "id_ingreso")
    ValeIngreso valeIngreso;

    public Long getId_detalle_ingreso() {
        return id_detalle_ingreso;
    }

    public void setId_detalle_ingreso(Long id_detalle_ingreso) {
        this.id_detalle_ingreso = id_detalle_ingreso;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public ValeIngreso getValeIngreso() {
        return valeIngreso;
    }

    public void setValeIngreso(ValeIngreso valeIngreso) {
        this.valeIngreso = valeIngreso;
    }
}
