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
    private Usuarios id_cliente;

    @Column(name = "peso", nullable = true)
    private Double peso;

    @Column(name = "repiticiones", nullable = true)
    private int repiticiones;

    @Column(name = "calorias", nullable = true)
    private Double calorias;

    @Column(name = "observaciones", nullable = true)
    private String observaciones;

    public Progresos() {}

    public Progresos(Long id, Long id_sesion, Long id_cliente, Double peso, int repiticiones, Double calorias, String observaciones) {
        this.id = id;
        this.id_sesion = id_sesion;
        this.id_cliente = id_cliente;
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

    public Long getId_sesion() {
        return id_sesion;
    }

    public void setId_sesion(Long id_sesion) {
        this.id_sesion = id_sesion;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
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
