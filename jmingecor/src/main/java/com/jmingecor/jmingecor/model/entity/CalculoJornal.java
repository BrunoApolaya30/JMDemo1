package com.jmingecor.jmingecor.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "calculo_jornal")
public class CalculoJornal implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calculo_jornal")
    private Long id_calculo_jornal;

    @ManyToOne
    @Column(name = "id_categoria")
    Categoria categoria;

    @Column(name = "sueldo_basico_jornal")
    private double sueldo_basico_jornal;

    @Column(name = "remuneracion_basica_dia_jornal")
    private double remuneracion_basica_dia_jornal;

    @Column(name = "horas_extra_proyectadas_jornal")
    private double horas_extra_proyectadas_jornal;

    @Column(name = "jornal")
    private double jornal;

    @Column(name = "vacaciones_truncas")
    private double vacaciones_truncas;

    @Column(name = "cts_jornal")
    private double cts_jornal;

    @Column(name = "gratificaciones_jornal")
    private double gratificaciones_jornal;

    @Column(name = "bonif_gratifica_jornal")
    private double bonif_gratifica_jornal;

    @Column(name = "essalud_jornal")
    private double essalud_jornal;

    @Column(name = "seguro_vida_jornal")
    private double seguro_vida_jornal;

    @Column(name = "bonific_movil_jornal")
    private double bonific_movil_jornal;

    @Column(name = "overol_jornal")
    private double overol_jornal;

    @Column(name = "sctr_jornal")
    private double sctr_jornal;

    @Column(name = "jornal_diario")
    private double jornal_diario;
    
    @Column(name = "jornal_horario")
    private double jornal_horario;
}
