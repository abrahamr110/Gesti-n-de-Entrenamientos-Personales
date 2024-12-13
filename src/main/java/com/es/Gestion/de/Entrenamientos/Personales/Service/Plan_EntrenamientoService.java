package com.es.Gestion.de.Entrenamientos.Personales.Service;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.Plan_EntrenamientoDTO;
import com.es.Gestion.de.Entrenamientos.Personales.DTO.UsuarioDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Plan_Entrenamiento;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Usuario;
import com.es.Gestion.de.Entrenamientos.Personales.Repository.UsuarioRepository;
import com.es.Gestion.de.Entrenamientos.Personales.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.es.Gestion.de.Entrenamientos.Personales.Repository.Plan_EntrenamientoRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class Plan_EntrenamientoService {
    @Autowired
    private Plan_EntrenamientoRepository plan_entrenamientoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Plan_EntrenamientoDTO getAll(){
        List<Plan_Entrenamiento> planes = plan_entrenamientoRepository.findAll();
        return Mapper.toDTOPlan(planes.get(0));
    }

    public Plan_EntrenamientoDTO getPlanById(Long id){
        Plan_Entrenamiento plan = plan_entrenamientoRepository.findById(id).orElse(null);
        return Mapper.toDTOPlan(plan);
    }

    public Plan_EntrenamientoDTO createPlan(Plan_EntrenamientoDTO plan) {
        Usuario entrenador = null;
        if (plan.getId_entrenador() != null) {
            entrenador = new Usuario(
                    null,
                    plan.getId_entrenador().getNombre(),
                    plan.getId_entrenador().getContrasena(),
                    plan.getId_entrenador().getCorreo(),
                    plan.getId_entrenador().getRol(),
                    plan.getId_entrenador().getFecha_creacion()
            );
        }

        Usuario cliente = null;
        if (plan.getId_cliente() != null) {
            cliente = new Usuario(
                    null,
                    plan.getId_cliente().getNombre(),
                    plan.getId_cliente().getContrasena(),
                    plan.getId_cliente().getCorreo(),
                    plan.getId_cliente().getRol(),
                    plan.getId_cliente().getFecha_creacion()
            );
        }

        Plan_Entrenamiento newPlan = new Plan_Entrenamiento(
                plan.getNombre(),
                plan.getDescripcion(),
                plan.getFecha_inicio(),
                plan.getFecha_final(),
                entrenador,
                cliente
        );

        Plan_Entrenamiento savedPlan = plan_entrenamientoRepository.save(newPlan);

        return Mapper.toDTOPlan(savedPlan);
    }

    public Plan_EntrenamientoDTO updatePlan(Long id, Plan_EntrenamientoDTO planDTO) {
        Plan_Entrenamiento existingPlan = plan_entrenamientoRepository.findById(id).orElse(null);

        if (existingPlan != null) {
            existingPlan.setNombre(planDTO.getNombre());
            existingPlan.setDescripcion(planDTO.getDescripcion());
            existingPlan.setFecha_inicio(planDTO.getFecha_inicio());
            existingPlan.setFecha_final(planDTO.getFecha_final());

            if (planDTO.getId_entrenador() != null) {
                Usuario entrenador = usuarioRepository.findById(planDTO.getId_entrenador().getId()).orElse(null);
                if (entrenador != null) {
                    existingPlan.setId_entrenador(entrenador);
                }
            }

            if (planDTO.getId_cliente() != null) {
                Usuario cliente = usuarioRepository.findById(planDTO.getId_cliente().getId()).orElse(null);
                if (cliente != null) {
                    existingPlan.setId_cliente(cliente);
                }
            }

            Plan_Entrenamiento updatedPlan = plan_entrenamientoRepository.save(existingPlan);

            return new Plan_EntrenamientoDTO(
                    updatedPlan.getNombre(),
                    updatedPlan.getDescripcion(),
                    updatedPlan.getFecha_inicio(),
                    updatedPlan.getFecha_final(),
                    updatedPlan.getId_entrenador(),
                    updatedPlan.getId_cliente()
            );
        }

        return null;
    }

    public void deletePlan(Long id) {
        plan_entrenamientoRepository.deleteById(id);
    }
}
