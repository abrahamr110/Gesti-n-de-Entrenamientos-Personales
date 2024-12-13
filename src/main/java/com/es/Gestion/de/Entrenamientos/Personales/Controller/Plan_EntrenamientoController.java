package com.es.Gestion.de.Entrenamientos.Personales.Controller;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.Plan_EntrenamientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.es.Gestion.de.Entrenamientos.Personales.Service.Plan_EntrenamientoService;

@RestController
@RequestMapping("/plan_entrenamiento")
public class Plan_EntrenamientoController {
    @Autowired
    private Plan_EntrenamientoService plan_entrenamientoService;

    @GetMapping("/")
    public ResponseEntity<Plan_EntrenamientoDTO> getAll() {
        return ResponseEntity.ok(plan_entrenamientoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plan_EntrenamientoDTO> getPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(plan_entrenamientoService.getPlanById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Plan_EntrenamientoDTO> createPlan(@RequestBody Plan_EntrenamientoDTO plan) {
        return ResponseEntity.ok(plan_entrenamientoService.createPlan(plan));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plan_EntrenamientoDTO> updatePlan(@PathVariable Long id, @RequestBody Plan_EntrenamientoDTO plan) {
        return ResponseEntity.ok(plan_entrenamientoService.updatePlan(id, plan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        plan_entrenamientoService.deletePlan(id);
        return ResponseEntity.noContent().build();
    }
}
