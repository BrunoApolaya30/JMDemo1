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
@Table(name = "valeSalida")
public class ValeSalida implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salida")
    private Long id_salida;

    @Column(name = "motivo")
    private String motivo;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_registro")
    private Date fecha;

    @Column(name = "doc_referencia")
    private String doc_referencia;

    //@ManyToOne
    @Column(name = "id_usuario")
    Usuario usuario;

    public Long getId_salida() {
        return id_salida;
    }

    public void setId_salida(Long id_salida) {
        this.id_salida = id_salida;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDoc_referencia() {
        return doc_referencia;
    }

    public void setDoc_referencia(String doc_referencia) {
        this.doc_referencia = doc_referencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
