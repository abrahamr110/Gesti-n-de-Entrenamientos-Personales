package com.es.Gestion.de.Entrenamientos.Personales.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "progresos")
public class Progresos {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_sesion", nullable = false)
    private Sesiones_Entrenamiento id_sesion;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Usuario id_cliente;

    @Column(name = "peso", nullable = true)
    private Double peso;

    @Column(name = "repiticiones", nullable = true)
    private int repiticiones;

    @Column(name = "calorias", nullable = true)
    private Double calorias;

    @Column(name = "observaciones", nullable = true)
    private String observaciones;

    public Progresos() {}

    public Progresos(Long id, Double peso, int repiticiones, Double calorias, String observaciones) {
        this.id = id;
        this.peso = peso;
        this.repiticiones = repiticiones;
        this.calorias = calorias;
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getCalorias() {
        return calorias;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    public int getRepiticiones() {
        return repiticiones;
    }

    public void setRepiticiones(int repiticiones) {
        this.repiticiones = repiticiones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
