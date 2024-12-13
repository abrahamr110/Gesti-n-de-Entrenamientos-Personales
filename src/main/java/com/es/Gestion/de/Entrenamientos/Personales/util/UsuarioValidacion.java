package com.es.Gestion.de.Entrenamientos.Personales.util;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.UsuarioRegisterDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UsuarioValidacion {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para validar el registro de un nuevo usuario
    public void validateUserRegistration(UsuarioRegisterDTO usuarioRegisterDTO) {
        // Validar si el nombre de usuario es nulo o vacío
        if (!StringUtils.hasText(usuarioRegisterDTO.getNombre())) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío");
        }

        // Verificar si el nombre de usuario ya existe
        if (usuarioRepository.findByUsername(usuarioRegisterDTO.getNombre()).isPresent()) {
            throw new IllegalArgumentException("El nombre de usuario ya está registrado");
        }

        // Validar la contraseña (mínimo 6 caracteres en este ejemplo)
        if (usuarioRegisterDTO.getContrasena() == null || usuarioRegisterDTO.getContrasena().length() < 6) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
        }

        // Validación de rol (esto es opcional dependiendo de tu lógica)
        if (usuarioRegisterDTO.getRol() == null || usuarioRegisterDTO.getRol().isEmpty()) {
            throw new IllegalArgumentException("El rol no puede estar vacío");
        }
    }
}

