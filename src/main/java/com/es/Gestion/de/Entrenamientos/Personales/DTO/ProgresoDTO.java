package com.es.Gestion.de.Entrenamientos.Personales.DTO;

import com.es.Gestion.de.Entrenamientos.Personales.Entities.Sesion_Entrenamiento;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Usuario;

public class ProgresoDTO {
    private Double peso;
    private int repeticiones;
    private Double calorias;
    private String observaciones;
    private Usuario id_cliente;
    private Sesion_Entrenamiento id_sesion;

    public ProgresoDTO(Double peso, int repeticiones, Double calorias, String observaciones,Usuario id_cliente, Sesion_Entrenamiento id_sesion) {
        this.peso = peso;
        this.repeticiones = repeticiones;
        this.calorias = calorias;
        this.observaciones = observaciones;
        this.id_cliente = id_cliente;
        this.id_sesion = id_sesion;
    }

    public Double getPeso() {
        return peso;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public Double getCalorias() {
        return calorias;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Usuario getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(Usuario id_cliente) {
        this.id_cliente = id_cliente;
    }
    public Sesion_Entrenamiento getId_sesion() {
        return id_sesion;
    }
    public void setId_sesion(Sesion_Entrenamiento id_sesion) {
        this.id_sesion = id_sesion;
    }
}
