package com.es.Gestion.de.Entrenamientos.Personales.DTO;

import java.util.Date;

public class Sesion_EntrenamientoDTO {
    private Date fecha;
    private Integer duracion;
    private String descripcion;

    public Sesion_EntrenamientoDTO(Date fecha, Integer duracion, String descripcion) {
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

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
