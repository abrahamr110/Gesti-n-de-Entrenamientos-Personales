package com.es.Gestion.de.Entrenamientos.Personales.Service;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.Plan_EntrenamientoDTO;
import com.es.Gestion.de.Entrenamientos.Personales.DTO.UsuarioDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Plan_Entrenamiento;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Usuario;
import com.es.Gestion.de.Entrenamientos.Personales.Repository.UsuarioRepository;
import com.es.Gestion.de.Entrenamientos.Personales.util.Mapper;
import com.es.Gestion.de.Entrenamientos.Personales.util.Plan_EntrenamientoValidacion;
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

    @Autowired
    private Plan_EntrenamientoValidacion planEntrenamientoValidacion;

    public Plan_EntrenamientoDTO getAll(){
        List<Plan_Entrenamiento> planes = plan_entrenamientoRepository.findAll();
        return Mapper.toDTOPlan(planes.get(0));
    }

    public Plan_EntrenamientoDTO getPlanById(Long id){
        Plan_Entrenamiento plan = plan_entrenamientoRepository.findById(id).orElse(null);
        return Mapper.toDTOPlan(plan);
    }

    public Plan_EntrenamientoDTO createPlan(Plan_EntrenamientoDTO plan) {
        planEntrenamientoValidacion.validateCreatePlan(plan);

        Plan_Entrenamiento newPlan = new Plan_Entrenamiento();
        newPlan.setNombre(plan.getNombre());
        newPlan.setDescripcion(plan.getDescripcion());
        newPlan.setFecha_inicio(plan.getFecha_inicio());
        newPlan.setFecha_final(plan.getFecha_final());

        if (plan.getId_entrenador() != null) {
            Usuario entrenador = usuarioRepository.findById(plan.getId_entrenador()).orElse(null);
            newPlan.setId_entrenador(entrenador);
        }

        if (plan.getId_cliente() != null) {
            Usuario cliente = usuarioRepository.findById(plan.getId_cliente()).orElse(null);
            newPlan.setId_cliente(cliente);
        }

        Plan_Entrenamiento savedPlan = plan_entrenamientoRepository.save(newPlan);
        return Mapper.toDTOPlan(savedPlan);
    }

    public Plan_EntrenamientoDTO updatePlan(Long id, Plan_EntrenamientoDTO planDTO) {
        planEntrenamientoValidacion.validateUpdatePlan(id, planDTO);

        Plan_Entrenamiento plan = plan_entrenamientoRepository.findById(id).orElse(null);
        plan.setNombre(planDTO.getNombre());
        plan.setDescripcion(planDTO.getDescripcion());
        plan.setFecha_inicio(planDTO.getFecha_inicio());
        plan.setFecha_final(planDTO.getFecha_final());

        if (planDTO.getId_entrenador() != null) {
            Usuario entrenador = usuarioRepository.findById(planDTO.getId_entrenador()).orElse(null);
            plan.setId_entrenador(entrenador);
        }

        if (planDTO.getId_cliente() != null) {
            Usuario cliente = usuarioRepository.findById(planDTO.getId_cliente()).orElse(null);
            plan.setId_cliente(cliente);
        }

        plan_entrenamientoRepository.save(plan);
        return Mapper.toDTOPlan(plan);
    }

    public void deletePlan(Long id) {
        planEntrenamientoValidacion.validateDeletePlan(id);

        plan_entrenamientoRepository.deleteById(id);
    }
}
