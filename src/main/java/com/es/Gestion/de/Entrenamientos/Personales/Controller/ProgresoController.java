package com.es.Gestion.de.Entrenamientos.Personales.Controller;


import com.es.Gestion.de.Entrenamientos.Personales.DTO.ProgresoDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Progreso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import com.es.Gestion.de.Entrenamientos.Personales.Service.ProgresoService;

import java.util.List;

@RestController
@RequestMapping("/progreso")
public class ProgresoController {

    @Autowired
    private ProgresoService progresoService;

    @GetMapping("/")
    public ResponseEntity<List<ProgresoDTO>> getAll() {
        try {
            List<ProgresoDTO> progresos = progresoService.getAll();

            return ResponseEntity.ok(progresos);
        } catch (IllegalArgumentException ex) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgresoDTO> getProgreso(@PathVariable Long id) {
        try {
            ProgresoDTO progreso = progresoService.getProgreso(id);
            return ResponseEntity.ok(progreso);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ProgresoDTO> addProgreso(@RequestBody ProgresoDTO progresoDTO) {
        try {
            ProgresoDTO newProgreso = progresoService.addProgreso(progresoDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(newProgreso);
        } catch (IllegalArgumentException ex) {
            // Error si las IDs no existen o los datos son incorrectos
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception ex) {
            // Manejo de otros errores
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgresoDTO> updateProgreso(@PathVariable Long id, @RequestBody Progreso progreso) {
        try {
            ProgresoDTO updatedProgreso = progresoService.updateProgreso(id, progreso);
            return ResponseEntity.ok(updatedProgreso);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProgresoDTO> deleteProgreso(@PathVariable Long id) {
        try {
            progresoService.deleteProgreso(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

