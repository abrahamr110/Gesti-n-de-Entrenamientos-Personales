package com.es.Gestion.de.Entrenamientos.Personales.Service;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.ProgresoDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Progreso;
import com.es.Gestion.de.Entrenamientos.Personales.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.es.Gestion.de.Entrenamientos.Personales.Repository.ProgresoRepository;

import java.util.List;

@Service
public class ProgresoService {
    @Autowired
    private ProgresoRepository progresoRepository;

    public ProgresoDTO getProgreso(Long id) {
        Progreso progreso = progresoRepository.findById(id).get();
        return Mapper.toDTOProgreso(progreso);
    }

    public ProgresoDTO getAll(){
        List<Progreso> progresos = progresoRepository.findAll();
        return Mapper.toDTOProgreso(progresos.get(0));
    }

    public ProgresoDTO addProgreso(Progreso progreso) {
        progresoRepository.save(progreso);
        return Mapper.toDTOProgreso(progreso);
    }

    public ProgresoDTO updateProgreso(Long id,Progreso progreso) {
        progresoRepository.save(progreso);
        return Mapper.toDTOProgreso(progreso);
    }

    public void deleteProgreso(Long id) {
        progresoRepository.deleteById(id);
    }
}
