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
@Table(name = "solicitudRequerimiento")
public class SolicitudRequerimiento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitudr")
    private Long id_solicitudr;

    @Column(name = "lugar_trabajo")
    private String lugar_trabajo;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_solicitada")
    private Date fecha_solicitada;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_requerida")
    private Date fecha_requerida;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_entrega_real")
    private Date fecha_entrega_real;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_fin_obra")
    private Date fecha_fin_obra;

    @Column(name = "solicitado")
    private String solicitado;

    @Column(name = "revisado")
    private String revisado;

    @Column(name = "aprobado")
    private String aprobado;

    @ManyToOne
    @Column(name = "id_usuario")
    Usuario usuario;

    @ManyToOne
    @Column(name = "id_cliente")
    Cliente cliente;

    @ManyToOne
    @Column(name = "id_cotizacion")
    Cotizacion cotizacion;

    public Long getId_solicitudr() {
        return id_solicitudr;
    }

    public void setId_solicitudr(Long id_solicitudr) {
        this.id_solicitudr = id_solicitudr;
    }

    public String getLugar_trabajo() {
        return lugar_trabajo;
    }

    public void setLugar_trabajo(String lugar_trabajo) {
        this.lugar_trabajo = lugar_trabajo;
    }

    public Date getFecha_solicitada() {
        return fecha_solicitada;
    }

    public void setFecha_solicitada(Date fecha_solicitada) {
        this.fecha_solicitada = fecha_solicitada;
    }

    public Date getFecha_requerida() {
        return fecha_requerida;
    }

    public void setFecha_requerida(Date fecha_requerida) {
        this.fecha_requerida = fecha_requerida;
    }

    public Date getFecha_entrega_real() {
        return fecha_entrega_real;
    }

    public void setFecha_entrega_real(Date fecha_entrega_real) {
        this.fecha_entrega_real = fecha_entrega_real;
    }

    public Date getFecha_fin_obra() {
        return fecha_fin_obra;
    }

    public void setFecha_fin_obra(Date fecha_fin_obra) {
        this.fecha_fin_obra = fecha_fin_obra;
    }

    public String getSolicitado() {
        return solicitado;
    }

    public void setSolicitado(String solicitado) {
        this.solicitado = solicitado;
    }

    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

}
