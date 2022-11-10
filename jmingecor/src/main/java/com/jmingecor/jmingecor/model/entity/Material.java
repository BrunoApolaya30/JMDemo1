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
@Table(name = "materiales")
public class Material implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materiales")
    private Long id;

    @Column(name = "nombre_material")
    private String nombre;

    @Column(name = "lugar_compra_material")
    private String lugar_compra_material;

    @Column(name = "precio_material")
    private double precio;

    @Column(name = "igv_material")
    private double igv_material;

    @Column(name = "precio_obra_material")
    private double precio_obra_material;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar_compra_material() {
        return lugar_compra_material;
    }

    public void setLugar_compra_material(String lugar_compra_material) {
        this.lugar_compra_material = lugar_compra_material;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIgv_material() {
        return igv_material;
    }

    public void setIgv_material(double igv_material) {
        this.igv_material = igv_material;
    }

    public double getPrecio_obra_material() {
        return precio_obra_material;
    }

    public void setPrecio_obra_material(double precio_obra_material) {
        this.precio_obra_material = precio_obra_material;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
