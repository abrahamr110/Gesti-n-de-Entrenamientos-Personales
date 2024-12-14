package com.es.Gestion.de.Entrenamientos.Personales.Service;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.ProgresoDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Progreso;
import com.es.Gestion.de.Entrenamientos.Personales.util.Mapper;
import com.es.Gestion.de.Entrenamientos.Personales.util.ProgresoValidacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.es.Gestion.de.Entrenamientos.Personales.Repository.ProgresoRepository;
import java.util.List;

@Service
public class ProgresoService {
    @Autowired
    private ProgresoRepository progresoRepository;

    @Autowired
    private ProgresoValidacion progresoValidacion;

    public ProgresoDTO getProgreso(Long id) {
        progresoValidacion.validateGetProgreso(id);

        Progreso progreso = progresoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró un progreso con el ID proporcionado."));
        return Mapper.toDTOProgreso(progreso);
    }

    public ProgresoDTO getAll() {
        List<Progreso> progresos = progresoRepository.findAll();
        if (progresos.isEmpty()) {
            throw new IllegalArgumentException("No hay registros de progreso disponibles.");
        }
        return Mapper.toDTOProgreso(progresos.get(0));
    }

    public ProgresoDTO addProgreso(Progreso progreso) {
        progresoValidacion.validateAddProgreso(progreso);

        progresoRepository.save(progreso);
        return Mapper.toDTOProgreso(progreso);
    }

    public ProgresoDTO updateProgreso(Long id, Progreso progreso) {
        progresoValidacion.validateUpdateProgreso(id, progreso);

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
