package com.es.Gestion.de.Entrenamientos.Personales.util;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.UsuarioDTO;
import com.es.Gestion.de.Entrenamientos.Personales.DTO.UsuarioRegisterDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UsuarioValidacion {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validateUserRegistration(UsuarioRegisterDTO usuarioRegisterDTO) {
        if (usuarioRegisterDTO.getNombre() == null || usuarioRegisterDTO.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío");
        }

        if (usuarioRepository.findByUsername(usuarioRegisterDTO.getNombre()).isPresent()) {
            throw new IllegalArgumentException("El nombre de usuario ya está registrado");
        }

        if (usuarioRegisterDTO.getContrasena() == null || usuarioRegisterDTO.getContrasena().length() < 6) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
        }

        if (usuarioRegisterDTO.getRol() == null || usuarioRegisterDTO.getRol().isEmpty()) {
            throw new IllegalArgumentException("El rol no puede estar vacío");
        }
    }

    public void validateGetUserById(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuario con el ID " + id + " no encontrado");
        }
    }

    public void validateUpdateUser(Long id, UsuarioDTO usuarioDTO) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuario con el ID " + id + " no encontrado");
        }

        if (usuarioDTO.getNombre() != null && usuarioDTO.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío");
        }

        if (usuarioDTO.getContrasena() != null && usuarioDTO.getContrasena().length() < 6) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
        }

        if (usuarioDTO.getRol() == null || usuarioDTO.getRol().isEmpty()) {
            throw new IllegalArgumentException("El rol no puede estar vacío");
        }
    }

    public void validateDeleteUser(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuario con el ID " + id + " no encontrado");
        }
    }

}

