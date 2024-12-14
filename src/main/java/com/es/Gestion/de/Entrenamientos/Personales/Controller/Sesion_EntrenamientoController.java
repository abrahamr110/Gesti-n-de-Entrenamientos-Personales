package com.es.Gestion.de.Entrenamientos.Personales.Controller;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.Sesion_EntrenamientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.es.Gestion.de.Entrenamientos.Personales.Service.Sesion_EntrenamientoService;

@RestController
@RequestMapping("/sesion_entrenamiento")
public class Sesion_EntrenamientoController {
    @Autowired
    private Sesion_EntrenamientoService sesion_entrenamientoService;

    @GetMapping("/")
    public ResponseEntity<Sesion_EntrenamientoDTO> getAll() {
        try{
            return ResponseEntity.ok(sesion_entrenamientoService.getAll());
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sesion_EntrenamientoDTO> getSesionById(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(sesion_entrenamientoService.getSesionById(id));
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Sesion_EntrenamientoDTO> createSesion(@RequestBody Sesion_EntrenamientoDTO sesion) {
        try{
            return ResponseEntity.ok(sesion_entrenamientoService.createSesion(sesion));
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sesion_EntrenamientoDTO> updateSesion(@PathVariable Long id, @RequestBody Sesion_EntrenamientoDTO sesion) {
        try{
            return ResponseEntity.ok(sesion_entrenamientoService.updateSesion(id, sesion));
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Sesion_EntrenamientoDTO> deleteSesion(@PathVariable Long id) {
        try{
            sesion_entrenamientoService.deleteSesion(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
