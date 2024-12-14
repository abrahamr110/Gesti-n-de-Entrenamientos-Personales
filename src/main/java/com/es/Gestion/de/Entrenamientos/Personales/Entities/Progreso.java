package com.es.Gestion.de.Entrenamientos.Personales.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "progresos")
public class Progreso {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_sesion", nullable = false)
    private Sesion_Entrenamiento id_sesion;

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

    public Progreso() {}

    public Progreso(Double peso, int repiticiones, Double calorias, String observaciones, Sesion_Entrenamiento id_sesion, Usuario id_cliente) {
        this.peso = peso;
        this.repiticiones = repiticiones;
        this.calorias = calorias;
        this.observaciones = observaciones;
        this.id_sesion = id_sesion;
        this.id_cliente = id_cliente;
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

    public Sesion_Entrenamiento getId_sesion() {
        return id_sesion;
    }

    public void setId_sesion(Sesion_Entrenamiento id_sesion) {
        this.id_sesion = id_sesion;
    }

    public Usuario getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Usuario id_cliente) {
        this.id_cliente = id_cliente;
    }
}
