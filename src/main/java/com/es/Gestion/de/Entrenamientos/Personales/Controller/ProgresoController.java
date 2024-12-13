package com.es.Gestion.de.Entrenamientos.Personales.Controller;


import com.es.Gestion.de.Entrenamientos.Personales.DTO.ProgresoDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Progreso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.es.Gestion.de.Entrenamientos.Personales.Service.ProgresoService;

@RestController
@RequestMapping("/progreso")
public class ProgresoController {
    @Autowired
    private ProgresoService progresoService;

    @GetMapping("/")
    public ProgresoDTO getAll() {
        return progresoService.getAll();
    }

    @GetMapping("/{id}")
    public ProgresoDTO getProgreso(@PathVariable Long id) {
        return progresoService.getProgreso(id);
    }

    @PutMapping("/{id}")
    public ProgresoDTO updateProgreso(@PathVariable Long id, @RequestBody Progreso progreso) {
        return progresoService.updateProgreso(id, progreso);
    }

    @PostMapping("/")
    public ProgresoDTO addProgreso(@RequestBody Progreso progreso) {
        return progresoService.addProgreso(progreso);
    }

    @DeleteMapping("/{id}")
    public void deleteProgreso(@PathVariable Long id) {
        progresoService.deleteProgreso(id);
    }
}
