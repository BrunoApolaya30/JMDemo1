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
@Table(name = "detalle_serviciovtecnica")
public class DetalleVTecnica implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_svtecnica")
    private Long id;

    @Column(name = "area_trabajo")
    private String areaTrabajo;

    @Column(name = "sistema_aplicar")
    private String sistemaAplicar;

    @Column(name = "datos_extra")
    private String datosExtra;

    @ManyToOne
    @JoinColumn(name = "id_informevtecnica")
    InformeVTecnica informevtecnica;
}
