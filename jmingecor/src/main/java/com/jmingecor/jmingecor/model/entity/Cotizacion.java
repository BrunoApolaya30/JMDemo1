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
@Table(name = "cotizacion")
public class Cotizacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cotizacion")
    private Long id;

    @Column(name = "fecha_cotizacion")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @Column(name = "obra")
    private String obraCo;

    @Column(name = "revision")
    private String revisionCo;

    @Column(name = "costo_directo")
    private Double costoDirecto;

    @Column(name = "gastos_generales")
    private Double gastosGenerales;

    @Column(name = "utilidad")
    private Double utilidadCo;

    @Column(name = "total")
    private Double totalCo;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObraCo() {
        return obraCo;
    }

    public void setObraCo(String obraCo) {
        this.obraCo = obraCo;
    }

    public String getRevisionCo() {
        return revisionCo;
    }

    public void setRevisionCo(String revisionCo) {
        this.revisionCo = revisionCo;
    }

    public Double getCostoDirecto() {
        return costoDirecto;
    }

    public void setCostoDirecto(Double costoDirecto) {
        this.costoDirecto = costoDirecto;
    }

    public Double getGastosGenerales() {
        return gastosGenerales;
    }

    public void setGastosGenerales(Double gastosGenerales) {
        this.gastosGenerales = gastosGenerales;
    }

    public Double getUtilidadCo() {
        return utilidadCo;
    }

    public void setUtilidadCo(Double utilidadCo) {
        this.utilidadCo = utilidadCo;
    }

    public Double getTotalCo() {
        return totalCo;
    }

    public void setTotalCo(Double totalCo) {
        this.totalCo = totalCo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    

    
}
