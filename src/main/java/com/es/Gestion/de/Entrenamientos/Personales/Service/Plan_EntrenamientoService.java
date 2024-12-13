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
        Plan_Entrenamiento newPlan = new Plan_Entrenamiento();
        newPlan.setNombre(plan.getNombre());
        newPlan.setDescripcion(plan.getDescripcion());
        newPlan.setFecha_inicio(plan.getFecha_inicio());
        newPlan.setFecha_final(plan.getFecha_final());

        if (plan.getId_entrenador() != null) {
            Usuario entrenador = usuarioRepository.findById(plan.getId_entrenador()).orElse(null);
            if (entrenador != null) {
                newPlan.setId_entrenador(entrenador.getId());
            }
        }

        if (plan.getId_cliente() != null) {
            Usuario cliente = usuarioRepository.findById(plan.getId_cliente()).orElse(null);
            if (cliente != null) {
                newPlan.setId_cliente(cliente.getId());
            }
        }

        plan_entrenamientoRepository.save(newPlan);
        return Mapper.toDTOPlan(newPlan);
    }

    public Plan_EntrenamientoDTO updatePlan(Long id, Plan_EntrenamientoDTO planDTO) {
       Plan_Entrenamiento plan = plan_entrenamientoRepository.findById(id).orElse(null);
       plan.setNombre(planDTO.getNombre());
       plan.setDescripcion(planDTO.getDescripcion());
       plan.setFecha_inicio(planDTO.getFecha_inicio());
       plan.setFecha_final(planDTO.getFecha_final());
       plan.setId_cliente(planDTO.getId_cliente());
       plan.setId_entrenador(planDTO.getId_entrenador());
       plan_entrenamientoRepository.save(plan);
       return Mapper.toDTOPlan(plan);
    }

    public void deletePlan(Long id) {
        plan_entrenamientoRepository.deleteById(id);
    }
}
