package com.es.Gestion.de.Entrenamientos.Personales.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sesiones_entrenamiento")
public class Sesiones_Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_planEntrenamiento;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "duracion", nullable = false)
    private int duracion;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public Sesiones_Entrenamiento() {}

    public Sesiones_Entrenamiento(Long id, Long id_planEntrenamiento, Date fecha_sesion, int duracion, String descripcion) {
        this.id = id;
        this.id_planEntrenamiento = id_planEntrenamiento;
        this.fecha = fecha_sesion;
        this.duracion = duracion;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_planEntrenamiento() {
        return id_planEntrenamiento;
    }

    public void setId_planEntrenamiento(Long id_planEntrenamiento) {
        this.id_planEntrenamiento = id_planEntrenamiento;
    }

    public Date getFecha_sesion() {
        return fecha;
    }

    public void setFecha_sesion(Date fecha_sesion) {
        this.fecha = fecha_sesion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
