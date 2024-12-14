package com.es.Gestion.de.Entrenamientos.Personales.DTO;

import java.util.Date;

public class Sesion_EntrenamientoDTO {
    private Date fecha;
    private int duracion;
    private String descripcion;
    private Long id_plan_entrenamiento;

    public Sesion_EntrenamientoDTO(Date fecha, int duracion, String descripcion) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.descripcion = descripcion;
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

    public Long getId_plan_entrenamiento() {
        return id_plan_entrenamiento;
    }

    public void setId_plan_entrenamiento(Long id_plan_entrenamiento) {
        this.id_plan_entrenamiento = id_plan_entrenamiento;
    }
}
