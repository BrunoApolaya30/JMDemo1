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
@Table(name = "seguimientoCotizaciones")
public class SeguimientoCotizaciones implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_scotizaciones")
    private Long id_scotizaciones;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    @Column(name = "valorizado")
    private String valorizado;

    @Column(name = "zona_trabajo")
    private String zona_trabajo;

    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne
    @Column(name = "id_cotizacion")
    Cotizacion cotizacion;

    @ManyToOne
    @Column(name = "id_cliente")
    Cliente cliente;

    @ManyToOne
    @Column(name = "id_usuario")
    Usuario usuario;

    public Long getId_scotizaciones() {
        return id_scotizaciones;
    }

    public void setId_scotizaciones(Long id_scotizaciones) {
        this.id_scotizaciones = id_scotizaciones;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getValorizado() {
        return valorizado;
    }

    public void setValorizado(String valorizado) {
        this.valorizado = valorizado;
    }

    public String getZona_trabajo() {
        return zona_trabajo;
    }

    public void setZona_trabajo(String zona_trabajo) {
        this.zona_trabajo = zona_trabajo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /*@ManyToOne
    @Column(name = "id_operaciones")
    Operaciones operaciones;

    @ManyToOne
    @Column(name = "id_estado")
    Estado estado;*/

    

}
