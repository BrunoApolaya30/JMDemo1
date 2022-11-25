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
@Table(name = "detalleValeSalida")
public class DetalleValeSalida implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_salida")
    private Long id_detalle_salida;

    @Column(name = "sku")
    private String sku;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "unidad_medida")
    private String unidad_medida;

    @Column(name = "observacion")
    private String observacion;

    @ManyToOne
    @Column(name = "id_salida")
    ValeSalida valeSalida;

    public Long getId_detalle_salida() {
        return id_detalle_salida;
    }

    public void setId_detalle_salida(Long id_detalle_salida) {
        this.id_detalle_salida = id_detalle_salida;
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

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public ValeSalida getValeSalida() {
        return valeSalida;
    }

    public void setValeSalida(ValeSalida valeSalida) {
        this.valeSalida = valeSalida;
    }

}
