package com.es.Gestion.de.Entrenamientos.Personales.Repository;

import com.es.Gestion.de.Entrenamientos.Personales.Entities.Progreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgresoRepository extends JpaRepository<Progreso, Long> {
}
