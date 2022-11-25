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
@Table(name = "SeguimientoOT")
public class SeguimientoOT implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seguimiento_ot")
    private Long id_seguimiento_ot;

    @Column(name = "monto_igv")
    private String monto_igv;

    @Column(name = "valorizado_igv")
    private String valorizado_igv;

    @Column(name = "descripcion_ztrabajo")
    private String descripcion_ztrabajo;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_inicio")
    private Date fecha_inicio;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_termino")
    private Date fecha_termino;

    @Column(name = "observaciones")
    private String observaciones;

    /*@ManyToOne
    @Column(name = "id_ot")
    OrdenTrabajo OrdenTrabajo;*/

    @ManyToOne
    @JoinColumn(name = "id_cotizacion")
    Cotizacion cotizacion;

    /*@ManyToOne
    @Column(name = "id_ocompra")
    OrdenCompra ordenCompra;*/

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    Usuario usuario;

    /*@ManyToOne
    @Column(name = "id_estado")
    Estado estado;*/

    /*@ManyToOne
    @Column(name = "id_operaciones")
    Operaciones operaciones;*/

    public Long getId_seguimiento_ot() {
        return id_seguimiento_ot;
    }

    public void setId_seguimiento_ot(Long id_seguimiento_ot) {
        this.id_seguimiento_ot = id_seguimiento_ot;
    }

    public String getMonto_igv() {
        return monto_igv;
    }

    public void setMonto_igv(String monto_igv) {
        this.monto_igv = monto_igv;
    }

    public String getValorizado_igv() {
        return valorizado_igv;
    }

    public void setValorizado_igv(String valorizado_igv) {
        this.valorizado_igv = valorizado_igv;
    }

    public String getDescripcion_ztrabajo() {
        return descripcion_ztrabajo;
    }

    public void setDescripcion_ztrabajo(String descripcion_ztrabajo) {
        this.descripcion_ztrabajo = descripcion_ztrabajo;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
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

}
