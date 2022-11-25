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
@Table(name ="orden_compra")
public class OrdenCompra implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ocompra")
    private Long id;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "ruc")
    private String rucOC;

    @Column(name = "lugar_entrega")
    private String lugarEntrega;

    @Column(name = "direccion")
    private String direccionOC;

    @Column(name = "telefono")
    private String telefonoOC;

    @Column(name = "forma_pago")
    private String formaPago;

    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEmision;

    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntrega;

    @Column(name = "aprobado")
    private String aprobadoOC;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRucOC() {
        return rucOC;
    }

    public void setRucOC(String rucOC) {
        this.rucOC = rucOC;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }

    public String getDireccionOC() {
        return direccionOC;
    }

    public void setDireccionOC(String direccionOC) {
        this.direccionOC = direccionOC;
    }

    public String getTelefonoOC() {
        return telefonoOC;
    }

    public void setTelefonoOC(String telefonoOC) {
        this.telefonoOC = telefonoOC;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getAprobadoOC() {
        return aprobadoOC;
    }

    public void setAprobadoOC(String aprobadoOC) {
        this.aprobadoOC = aprobadoOC;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
