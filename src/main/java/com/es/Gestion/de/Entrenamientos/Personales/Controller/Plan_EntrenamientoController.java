package com.es.Gestion.de.Entrenamientos.Personales.Controller;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.Plan_EntrenamientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.es.Gestion.de.Entrenamientos.Personales.Service.Plan_EntrenamientoService;

import java.util.List;

@RestController
@RequestMapping("/plan_entrenamiento")
public class Plan_EntrenamientoController {
    @Autowired
    private Plan_EntrenamientoService plan_entrenamientoService;

    @GetMapping("/")
    public ResponseEntity<List<Plan_EntrenamientoDTO>> getAll() {
        try {
            List<Plan_EntrenamientoDTO> planes = plan_entrenamientoService.getAll();
            return ResponseEntity.ok(planes);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Plan_EntrenamientoDTO> getPlanById(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(plan_entrenamientoService.getPlanById(id));
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Plan_EntrenamientoDTO> createPlan(@RequestBody Plan_EntrenamientoDTO plan) {
        try{
            return ResponseEntity.ok(plan_entrenamientoService.createPlan(plan));
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plan_EntrenamientoDTO> updatePlan(@PathVariable Long id, @RequestBody Plan_EntrenamientoDTO plan) {
        try{
            return ResponseEntity.ok(plan_entrenamientoService.updatePlan(id, plan));
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
       try {
           plan_entrenamientoService.deletePlan(id);
           return ResponseEntity.noContent().build();
       }catch (IllegalArgumentException ex){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }catch (Exception ex){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }
}
