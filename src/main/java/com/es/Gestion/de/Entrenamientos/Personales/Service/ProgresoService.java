package com.es.Gestion.de.Entrenamientos.Personales.Service;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.ProgresoDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Progreso;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Sesion_Entrenamiento;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Usuario;
import com.es.Gestion.de.Entrenamientos.Personales.Repository.Sesion_EntrenamientoRepository;
import com.es.Gestion.de.Entrenamientos.Personales.Repository.UsuarioRepository;
import com.es.Gestion.de.Entrenamientos.Personales.util.Mapper;
import com.es.Gestion.de.Entrenamientos.Personales.util.ProgresoValidacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.es.Gestion.de.Entrenamientos.Personales.Repository.ProgresoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgresoService {
    @Autowired
    private ProgresoRepository progresoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository; // Repositorio para buscar el cliente (usuario)

    @Autowired
    private Sesion_EntrenamientoRepository sesionRepository;

    @Autowired
    private ProgresoValidacion progresoValidacion;

    public ProgresoDTO getProgreso(Long id) {
        progresoValidacion.validateGetProgreso(id);

        Progreso progreso = progresoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró un progreso con el ID proporcionado."));
        return Mapper.toDTOProgreso(progreso);
    }

    public List<ProgresoDTO> getAll() {
        List<Progreso> progresos = progresoRepository.findAll();
        List<ProgresoDTO> progresoDTOs = new ArrayList<>();

        progresos.forEach(progreso -> {
            ProgresoDTO progresoDTO = Mapper.toDTOProgreso(progreso);
            progresoDTOs.add(progresoDTO);
        });

        return progresoDTOs;
    }

    public ProgresoDTO addProgreso(ProgresoDTO progresoDTO) {
        progresoValidacion.validateAddProgreso(progresoDTO);

        Usuario cliente = usuarioRepository.findById(progresoDTO.getId_cliente().getId())
                .orElseThrow(() -> new IllegalArgumentException("El cliente con ID " + progresoDTO.getId_cliente() + " no existe."));

        Sesion_Entrenamiento sesion = sesionRepository.findById(progresoDTO.getId_sesion().getId())
                .orElseThrow(() -> new IllegalArgumentException("La sesión de entrenamiento con ID " + progresoDTO.getId_sesion() + " no existe."));

        Progreso progreso = new Progreso(
                progresoDTO.getPeso(),
                progresoDTO.getRepeticiones(),
                progresoDTO.getCalorias(),
                progresoDTO.getObservaciones(),
                sesion,
                cliente
        );

        Progreso savedProgreso = progresoRepository.save(progreso);

        return Mapper.toDTOProgreso(savedProgreso);
    }

    public ProgresoDTO updateProgreso(Long id, Progreso progreso) {
        progresoValidacion.validateUpdateProgreso(id, Mapper.toDTOProgreso(progreso));

        Progreso existingProgreso = progresoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró un progreso con el ID proporcionado."));

        existingProgreso.setPeso(progreso.getPeso());
        existingProgreso.setRepiticiones(progreso.getRepiticiones());
        existingProgreso.setCalorias(progreso.getCalorias());
        existingProgreso.setObservaciones(progreso.getObservaciones());

        progresoRepository.save(existingProgreso);
        return Mapper.toDTOProgreso(existingProgreso);
    }

    public void deleteProgreso(Long id) {
        progresoValidacion.validateDeleteProgreso(id);

        progresoRepository.deleteById(id);
    }
}
