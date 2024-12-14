package com.es.Gestion.de.Entrenamientos.Personales.DTO;

import java.util.Date;

public class UsuarioRegisterDTO {
    private String nombre;
    private String contrasena;
    private String rol;
    private Date fecha_creacion;
    private String correo;


    public UsuarioRegisterDTO(String nombre, String contrasena, String rol, String correo, Date fecha_creacion) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
        this.correo = correo;
        this.fecha_creacion = fecha_creacion;
    }

    public UsuarioRegisterDTO(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String password) {
        this.contrasena = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
