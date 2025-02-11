package com.es.Gestion.de.Entrenamientos.Personales.DTO;

import java.util.Date;

public class UsuarioDTO {
    private String nombre;
    private String correo;
    private String contrasena;
    private String rol;
    private Date fecha_creacion;

    public UsuarioDTO(String nombre, String correo, String contrasena, String rol, Date fecha_creacion) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.fecha_creacion = fecha_creacion;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public Date getFecha_creacion() {
        return fecha_creacion;
    }
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

}
