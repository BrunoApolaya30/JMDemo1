package com.jmingecor.jmingecor.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servicio_cotizacion")
public class ServicioCotizacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long id;

    @Column(name = "descripcion")
    private String descripcionServ;

    @Column(name = "unidad")
    private String unidadServ;

    @Column(name = "metrado")
    private Double metradoServ;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "parcial")
    private Double parcialServ;

    @ManyToOne
    @JoinColumn(name = "id_cotizacion")
    Cotizacion cotizacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionServ() {
        return descripcionServ;
    }

    public void setDescripcionServ(String descripcionServ) {
        this.descripcionServ = descripcionServ;
    }

    public String getUnidadServ() {
        return unidadServ;
    }

    public void setUnidadServ(String unidadServ) {
        this.unidadServ = unidadServ;
    }

    public Double getMetradoServ() {
        return metradoServ;
    }

    public void setMetradoServ(Double metradoServ) {
        this.metradoServ = metradoServ;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getParcialServ() {
        return parcialServ;
    }

    public void setParcialServ(Double parcialServ) {
        this.parcialServ = parcialServ;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    
}
