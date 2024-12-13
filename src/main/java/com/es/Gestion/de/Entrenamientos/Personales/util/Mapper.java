package com.es.Gestion.de.Entrenamientos.Personales.util;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.Plan_EntrenamientoDTO;
import com.es.Gestion.de.Entrenamientos.Personales.DTO.UsuarioDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Plan_Entrenamiento;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Usuario;

public class Mapper {
    private Mapper() {}

    public static UsuarioDTO toDTO(Usuario user) {
        return new UsuarioDTO(user.getNombre(), user.getCorreo(), user.getContrasena(), user.getRol(), user.getFecha_creacion());
    }

    public static Plan_EntrenamientoDTO toDTOPlan(Plan_Entrenamiento plan) {
        // Verificar si el entrenador y el cliente están presentes y mapearlos a DTOs sin el id
        UsuarioDTO entrenadorDTO = (plan.getId_entrenador() != null)
                ? new UsuarioDTO(
                plan.getId_entrenador().getNombre(),
                plan.getId_entrenador().getCorreo(),
                plan.getId_entrenador().getRol(),
                plan.getId_entrenador().getContrasena())
                : null;

        UsuarioDTO clienteDTO = (plan.getId_cliente() != null)
                ? new UsuarioDTO(
                plan.getId_cliente().getNombre(),
                plan.getId_cliente().getCorreo(),
                plan.getId_cliente().getRol(),
                plan.getId_cliente().getContrasena())
                : null;

        return new Plan_EntrenamientoDTO(
                plan.getNombre(),
                plan.getDescripcion(),
                plan.getFecha_inicio(),
                plan.getFecha_final(),
                entrenadorDTO,
                clienteDTO
        );
    }


}
