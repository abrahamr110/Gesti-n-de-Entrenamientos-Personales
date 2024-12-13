package com.es.Gestion.de.Entrenamientos.Personales.DTO;

public class UsuarioRegisterDTO {
    private String nombre;
    private String contrasena;
    private String rol;


    public UsuarioRegisterDTO(String nombre, String contrasena, String rol) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
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

    public void setRol(String roles) {
        this.rol = rol;
    }
}
