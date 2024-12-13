package com.es.Gestion.de.Entrenamientos.Personales.Controller;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.Sesion_EntrenamientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.es.Gestion.de.Entrenamientos.Personales.Service.Sesion_EntrenamientoService;

@RestController
@RequestMapping("/sesion_entrenamiento")
public class Sesion_EntrenamientoController {
    @Autowired
    private Sesion_EntrenamientoService sesion_entrenamientoService;

    @GetMapping("/")
    public Sesion_EntrenamientoDTO getAll() {
        return sesion_entrenamientoService.getAll();
    }

    @GetMapping("/{id}")
    public Sesion_EntrenamientoDTO getSesionById(@PathVariable Long id) {
        return sesion_entrenamientoService.getSesionById(id);
    }

    @PostMapping("/")
    public Sesion_EntrenamientoDTO createSesion(@RequestBody Sesion_EntrenamientoDTO sesion) {
        return sesion_entrenamientoService.createSesion(sesion);
    }

    @PutMapping("/{id}")
    public Sesion_EntrenamientoDTO updateSesion(@PathVariable Long id, @RequestBody Sesion_EntrenamientoDTO sesion) {
        return sesion_entrenamientoService.updateSesion(id, sesion);
    }

    @DeleteMapping("/{id}")
    public void deleteSesion(@PathVariable Long id) {
        sesion_entrenamientoService.deleteSesion(id);
    }
}
