package com.es.Gestion.de.Entrenamientos.Personales.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "planes_entrenamiento")
public class Plan_Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_entrenador", nullable = true)
    private Usuario id_entrenador;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = true)
    private Usuario id_cliente;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fecha_inicio;

    @Column(name = "fecha_final", nullable = true)
    private Date fecha_final;

    public Plan_Entrenamiento() {}

    public Plan_Entrenamiento(String nombre, String descripcion, Date fecha_inicio, Date fecha_final) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getId_entrenador() {
        return id_entrenador;
    }

    public void setId_entrenador(Usuario id_entrenador) {
        this.id_entrenador = id_entrenador;
    }

    public Usuario getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Usuario id_cliente) {
        this.id_cliente = id_cliente;
    }
}
