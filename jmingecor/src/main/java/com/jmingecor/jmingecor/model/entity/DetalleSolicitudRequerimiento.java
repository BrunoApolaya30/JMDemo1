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
@Table(name = "detalleSolicitudRequerimiento")
public class DetalleSolicitudRequerimiento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dsrequerimiento")
    private Long id_dsrequerimiento;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "unidad")
    private String unidad;

    @Column(name = "consumo_devolutivo")
    private String consumo_devolutivo;

    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne
    @Column(name = "id_equipo")
    Equipo equipo;

    @ManyToOne
    @Column(name = "id_materiales")
    Material material;

    public Long getId_dsrequerimiento() {
        return id_dsrequerimiento;
    }

    public void setId_dsrequerimiento(Long id_dsrequerimiento) {
        this.id_dsrequerimiento = id_dsrequerimiento;
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

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getConsumo_devolutivo() {
        return consumo_devolutivo;
    }

    public void setConsumo_devolutivo(String consumo_devolutivo) {
        this.consumo_devolutivo = consumo_devolutivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

}
