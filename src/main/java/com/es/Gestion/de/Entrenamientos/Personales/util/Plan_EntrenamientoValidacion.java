package com.es.Gestion.de.Entrenamientos.Personales.util;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.Plan_EntrenamientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.es.Gestion.de.Entrenamientos.Personales.Repository.Plan_EntrenamientoRepository;
import com.es.Gestion.de.Entrenamientos.Personales.Repository.UsuarioRepository;

@Component
public class Plan_EntrenamientoValidacion {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private Plan_EntrenamientoRepository planEntrenamientoRepository;

    public void validateCreatePlan(Plan_EntrenamientoDTO plan) {
        if (plan.getNombre() == null || plan.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del plan no puede estar vacío");
        }

        if (plan.getDescripcion() == null || plan.getDescripcion().isEmpty()) {
            throw new IllegalArgumentException("La descripción del plan no puede estar vacía");
        }

        if (plan.getFecha_inicio() == null) {
            throw new IllegalArgumentException("La fecha de inicio no puede estar vacía");
        }

        if (plan.getFecha_final() == null) {
            throw new IllegalArgumentException("La fecha final no puede estar vacía");
        }

        if (plan.getFecha_final().before(plan.getFecha_inicio())) {
            throw new IllegalArgumentException("La fecha final no puede ser anterior a la fecha de inicio");
        }

        if (plan.getId_entrenador() != null) {
            if (!usuarioRepository.existsById(plan.getId_entrenador())) {
                throw new IllegalArgumentException("El entrenador especificado no existe");
            }
        }

        if (plan.getId_cliente() != null) {
            if (!usuarioRepository.existsById(plan.getId_cliente())) {
                throw new IllegalArgumentException("El cliente especificado no existe");
            }
        }
    }

    public void validateUpdatePlan(Long id, Plan_EntrenamientoDTO plan) {
        if (!planEntrenamientoRepository.existsById(id)) {
            throw new IllegalArgumentException("El plan con el ID " + id + " no existe");
        }

        if (plan.getNombre() != null && plan.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del plan no puede estar vacío");
        }

        if (plan.getFecha_final() != null && plan.getFecha_inicio() != null
                && plan.getFecha_final().before(plan.getFecha_inicio())) {
            throw new IllegalArgumentException("La fecha final no puede ser anterior a la fecha de inicio");
        }

        if (plan.getId_entrenador() != null) {
            if (!usuarioRepository.existsById(plan.getId_entrenador())) {
                throw new IllegalArgumentException("El entrenador especificado no existe");
            }
        }

        if (plan.getId_cliente() != null) {
            if (!usuarioRepository.existsById(plan.getId_cliente())) {
                throw new IllegalArgumentException("El cliente especificado no existe");
            }
        }
    }

    public void validateDeletePlan(Long id) {
        if (!planEntrenamientoRepository.existsById(id)) {
            throw new IllegalArgumentException("El plan con el ID " + id + " no existe");
        }
    }
}
