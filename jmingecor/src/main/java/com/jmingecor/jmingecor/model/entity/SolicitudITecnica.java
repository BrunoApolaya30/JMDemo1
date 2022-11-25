package com.jmingecor.jmingecor.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "solicitudITecnica")
public class SolicitudITecnica implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitudit")
    private Long id_solicitudit;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "asesor_comercial")
    private String asesor_comercial;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "hora_inicio")
    private String hora_inicio;

    @Column(name = "hora_salida")
    private String hora_salida;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_cotizar")
    private Date fecha_cotizar;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "solicitado")
    private String solicitado;

    @Column(name = "personal")
    private String personal;

    @Column(name = "aprobado")
    private String aprobado;

    @ManyToOne
    @Column(name = "id_cliente")
    Cliente cliente;

    @ManyToOne
    @Column(name = "id_contacto_campo")
    ContactoCampo contactoCampo;

    public Long getId_solicitudit() {
        return id_solicitudit;
    }

    public void setId_solicitudit(Long id_solicitudit) {
        this.id_solicitudit = id_solicitudit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getAsesor_comercial() {
        return asesor_comercial;
    }

    public void setAsesor_comercial(String asesor_comercial) {
        this.asesor_comercial = asesor_comercial;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public Date getFecha_cotizar() {
        return fecha_cotizar;
    }

    public void setFecha_cotizar(Date fecha_cotizar) {
        this.fecha_cotizar = fecha_cotizar;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getSolicitado() {
        return solicitado;
    }

    public void setSolicitado(String solicitado) {
        this.solicitado = solicitado;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ContactoCampo getContactoCampo() {
        return contactoCampo;
    }

    public void setContactoCampo(ContactoCampo contactoCampo) {
        this.contactoCampo = contactoCampo;
    }
}
