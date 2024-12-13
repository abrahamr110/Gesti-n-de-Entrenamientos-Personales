package com.es.Gestion.de.Entrenamientos.Personales.Service;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.Sesion_EntrenamientoDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Sesion_Entrenamiento;
import com.es.Gestion.de.Entrenamientos.Personales.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.Gestion.de.Entrenamientos.Personales.Repository.Sesion_EntrenamientoRepository;

import java.util.List;

@Service
public class Sesion_EntrenamientoService {
    @Autowired
    private Sesion_EntrenamientoRepository sesionRepository;

    public Sesion_EntrenamientoDTO getAll(){
        List<Sesion_Entrenamiento> sesiones = sesionRepository.findAll();
        return Mapper.toDTOSesion(sesiones.get(0));
    }

    public Sesion_EntrenamientoDTO getSesionById(Long id){
        Sesion_Entrenamiento sesion = sesionRepository.findById(id).orElse(null);
        return Mapper.toDTOSesion(sesion);
    }

    public Sesion_EntrenamientoDTO createSesion(Sesion_EntrenamientoDTO sesionDTO) {
        Sesion_Entrenamiento sesion = new Sesion_Entrenamiento(sesionDTO.getFecha(), sesionDTO.getDuracion(), sesionDTO.getDescripcion());
        Sesion_Entrenamiento savedSesion = sesionRepository.save(sesion);
        return Mapper.toDTOSesion(savedSesion);
    }

    public Sesion_EntrenamientoDTO updateSesion(Long id,Sesion_EntrenamientoDTO sesionDTO) {
        Sesion_Entrenamiento sesion = new Sesion_Entrenamiento(sesionDTO.getFecha(), sesionDTO.getDuracion(), sesionDTO.getDescripcion());
        Sesion_Entrenamiento savedSesion = sesionRepository.save(sesion);
        return Mapper.toDTOSesion(savedSesion);
    }

    public Sesion_EntrenamientoDTO deleteSesion(Long id) {
        Sesion_Entrenamiento sesion = sesionRepository.findById(id).orElse(null);
        sesionRepository.delete(sesion);
        return Mapper.toDTOSesion(sesion);
    }
}
