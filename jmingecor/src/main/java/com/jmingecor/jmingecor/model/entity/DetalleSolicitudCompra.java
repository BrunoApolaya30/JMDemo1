package com.jmingecor.jmingecor.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalleSolicitudCompra")
public class DetalleSolicitudCompra implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetalle_scompra")
    private Long iddetalle_scompra;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "unidad_medida")
    private String unidad_medida;

    @Column(name = "monto")
    private String monto;

    @Column(name = "monto_total")
    private String monto_total;

    @Column(name = "observaciones")
    private String observaciones;

    //@ManyToOne
    @Column(name = "id_scompra")
    SolicitudCompra scompra;

    public Long getIddetalle_scompra() {
        return iddetalle_scompra;
    }

    public void setIddetalle_scompra(Long iddetalle_scompra) {
        this.iddetalle_scompra = iddetalle_scompra;
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

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(String monto_total) {
        this.monto_total = monto_total;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public SolicitudCompra getScompra() {
        return scompra;
    }

    public void setScompra(SolicitudCompra scompra) {
        this.scompra = scompra;
    }



}
