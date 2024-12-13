package com.es.Gestion.de.Entrenamientos.Personales.DTO;

public class ProgresoDTO {
    private Double peso;
    private int repeticiones;
    private Double calorias;
    private String observaciones;

    public ProgresoDTO(Double peso, int repeticiones, Double calorias, String observaciones) {
        this.peso = peso;
        this.repeticiones = repeticiones;
        this.calorias = calorias;
        this.observaciones = observaciones;
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
}
