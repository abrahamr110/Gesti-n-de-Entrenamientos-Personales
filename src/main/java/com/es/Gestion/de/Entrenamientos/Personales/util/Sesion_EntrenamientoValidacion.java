package com.es.Gestion.de.Entrenamientos.Personales.util;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.Sesion_EntrenamientoDTO;
import org.springframework.stereotype.Component;

@Component
public class Sesion_EntrenamientoValidacion {

    public void validateSesionCreation(Sesion_EntrenamientoDTO sesionDTO) {
        if (sesionDTO.getFecha() == null) {
            throw new IllegalArgumentException("La fecha de la sesión es obligatoria");
        }
        if (sesionDTO.getDuracion() == null || sesionDTO.getDuracion() <= 0) {
            throw new IllegalArgumentException("La duración de la sesión debe ser mayor a 0");
        }
        if (sesionDTO.getDescripcion() == null || sesionDTO.getDescripcion().isEmpty()) {
            throw new IllegalArgumentException("La descripción de la sesión es obligatoria");
        }
    }

    public void validateSesionUpdate(Long id, Sesion_EntrenamientoDTO sesionDTO) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID de la sesión debe ser mayor a 0");
        }
        if (sesionDTO.getDuracion() != null && sesionDTO.getDuracion() <= 0) {
            throw new IllegalArgumentException("La duración de la sesión debe ser mayor a 0");
        }
        if (sesionDTO.getDescripcion() != null && sesionDTO.getDescripcion().isEmpty()) {
            throw new IllegalArgumentException("La descripción de la sesión no puede estar vacía");
        }
    }

    public void validateSesionDeletion(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID de la sesión debe ser mayor a 0");
        }
    }
}

