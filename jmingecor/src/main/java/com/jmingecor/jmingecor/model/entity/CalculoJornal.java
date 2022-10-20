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
    public Long id_calculo_jornal;
    
    //@ManyToOne
    //@Column(name = "id_categoria")
    //Categoria categoria;

    @Column(name = "sueldo_basico_jornal")
    public double sueldo_basico_jornal;

    @Column(name = "remuneracion_basica_dia_jornal")
    public double remuneracion_basica_dia_jornal;

    @Column(name = "horas_extra_proyectadas_jornal")
    public double horas_extra_proyectadas_jornal;

    @Column(name = "jornal")
    public double jornal;

    @Column(name = "vacaciones_truncas")
    public double vacaciones_truncas;

    @Column(name = "cts_jornal")
    public double cts_jornal;

    @Column(name = "gratificaciones_jornal")
    public double gratificaciones_jornal;

    @Column(name = "bonif_gratifica_jornal")
    public double bonif_gratifica_jornal;

    @Column(name = "essalud_jornal")
    public double essalud_jornal;

    @Column(name = "seguro_vida_jornal")
    public double seguro_vida_jornal;

    @Column(name = "bonific_movil_jornal")
    public double bonific_movil_jornal;

    @Column(name = "overol_jornal")
    public double overol_jornal;

    @Column(name = "sctr_jornal")
    public double sctr_jornal;

    @Column(name = "jornal_diario")
    public double jornal_diario;
    
    @Column(name = "jornal_horario")
    public double jornal_horario;
}
