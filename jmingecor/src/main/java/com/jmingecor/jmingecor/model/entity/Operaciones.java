package com.jmingecor.jmingecor.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="operaciones")
public class Operaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operaciones")
    private Long id;
    
    @Column(name = "descripcion")
    private String descripcionOp;
}
