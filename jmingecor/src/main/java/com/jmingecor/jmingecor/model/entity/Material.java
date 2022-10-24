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
    private Long id_materiales;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    Categoria categoria;

    @Column(name = "nombre_material")
    private String nombre_material;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Column(name = "lugar_compra_material")
    private String lugar_compra_material;

    @Column(name = "precio_material")
    private double precio_material;

    @Column(name = "igv_material")
    private double igv_material;

    @Column(name = "precio_obra_material")
    private double precio_obra_material;
}
