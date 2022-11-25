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
@Table(name ="detalle_ordencompra")
public class DetalleOrdenCompra implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_compra")
    private Long id;

    @Column(name = "descripcion")
    private String descripcionDetalleOC;

    @Column(name = "cantidad")
    private int cantidadDetalleOC;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "monto")
    private Double montoDetalleOC;

    @Column(name = "subtotal")
    private Double subtotalDetalleOC;

    @Column(name = "total")
    private String totalDetalleOC;

    @ManyToOne
    @JoinColumn(name = "id_ocompra")
    OrdenCompra ordenCompra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionDetalleOC() {
        return descripcionDetalleOC;
    }

    public void setDescripcionDetalleOC(String descripcionDetalleOC) {
        this.descripcionDetalleOC = descripcionDetalleOC;
    }

    public int getCantidadDetalleOC() {
        return cantidadDetalleOC;
    }

    public void setCantidadDetalleOC(int cantidadDetalleOC) {
        this.cantidadDetalleOC = cantidadDetalleOC;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getMontoDetalleOC() {
        return montoDetalleOC;
    }

    public void setMontoDetalleOC(Double montoDetalleOC) {
        this.montoDetalleOC = montoDetalleOC;
    }

    public Double getSubtotalDetalleOC() {
        return subtotalDetalleOC;
    }

    public void setSubtotalDetalleOC(Double subtotalDetalleOC) {
        this.subtotalDetalleOC = subtotalDetalleOC;
    }

    public String getTotalDetalleOC() {
        return totalDetalleOC;
    }

    public void setTotalDetalleOC(String totalDetalleOC) {
        this.totalDetalleOC = totalDetalleOC;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    
}
