package com.es.Gestion.de.Entrenamientos.Personales.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "planes_entrenamiento")
public class Planes_Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_entrenador", nullable = true)
    private Long id_entrenador;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = true)
    private Long id_cliente;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private String fecha_inicio;

    @Column(name = "fecha_final", nullable = true)
    private String fecha_final;

    public Planes_Entrenamiento() {}

    public Planes_Entrenamiento(Long id, Long id_entrenador, Long id_cliente, String nombre, String descripcion, String fecha_inicio, String fecha_final) {
        this.id = id;
        this.id_entrenador = id_entrenador;
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_entrenador() {
        return id_entrenador;
    }

    public void setId_entrenador(Long id_entrenador) {
        this.id_entrenador = id_entrenador;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
