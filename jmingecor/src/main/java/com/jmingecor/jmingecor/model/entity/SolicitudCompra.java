package com.jmingecor.jmingecor.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "solicitudCompra")
public class SolicitudCompra implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_scompra")
    private Long id_scompra;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_solicitada")
    private Date fecha_solicitada;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_registro")
    private Date fecha_registro;

    @Column(name = "solicitado")
    private String solicitado;

    @Column(name = "revisado")
    private String revisado;

    //@ManyToOne
    @Column(name = "id_usuario")
    Usuario usuario;

    //@ManyToOne
    @Column(name = "id_cliente")
    Cliente cliente;

    public Long getId_scompra() {
        return id_scompra;
    }

    public void setId_scompra(Long id_scompra) {
        this.id_scompra = id_scompra;
    }

    public Date getFecha_solicitada() {
        return fecha_solicitada;
    }

    public void setFecha_solicitada(Date fecha_solicitada) {
        this.fecha_solicitada = fecha_solicitada;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
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


}
