package com.es.Gestion.de.Entrenamientos.Personales.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sesiones_entrenamiento")
public class Sesion_Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_planEntrenamiento", nullable = false)
    private Plan_Entrenamiento id_planEntrenamiento;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "duracion", nullable = false)
    private int duracion;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public Sesion_Entrenamiento() {}

    public Sesion_Entrenamiento(Date fecha, int duracion, String descripcion) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
