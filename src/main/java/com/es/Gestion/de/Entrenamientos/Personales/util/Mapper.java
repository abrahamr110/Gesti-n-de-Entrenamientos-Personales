package com.es.Gestion.de.Entrenamientos.Personales.util;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.Plan_EntrenamientoDTO;
import com.es.Gestion.de.Entrenamientos.Personales.DTO.ProgresoDTO;
import com.es.Gestion.de.Entrenamientos.Personales.DTO.Sesion_EntrenamientoDTO;
import com.es.Gestion.de.Entrenamientos.Personales.DTO.UsuarioDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Plan_Entrenamiento;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Progreso;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Sesion_Entrenamiento;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Usuario;

public class Mapper {
    private Mapper() {}

    public static UsuarioDTO toDTO(Usuario user) {
        return new UsuarioDTO(user.getNombre(), user.getCorreo(), user.getContrasena(), user.getRol(), user.getFecha_creacion());
    }

    public static Plan_EntrenamientoDTO toDTOPlan(Plan_Entrenamiento plan) {
        return new Plan_EntrenamientoDTO(plan.getNombre(), plan.getDescripcion(), plan.getFecha_inicio(), plan.getFecha_final());
    }

    public static Sesion_EntrenamientoDTO toDTOSesion(Sesion_Entrenamiento sesion) {
        return new Sesion_EntrenamientoDTO(sesion.getFecha_sesion(), sesion.getDuracion(), sesion.getDescripcion());
    }

    public static ProgresoDTO toDTOProgreso(Progreso progreso) {
        return new ProgresoDTO(progreso.getCalorias(),progreso.getRepiticiones(),progreso.getPeso(), progreso.getObservaciones());
    }
}
