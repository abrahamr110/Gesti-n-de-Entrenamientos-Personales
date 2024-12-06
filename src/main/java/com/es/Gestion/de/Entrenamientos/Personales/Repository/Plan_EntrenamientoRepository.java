package com.es.Gestion.de.Entrenamientos.Personales.Repository;

import com.es.Gestion.de.Entrenamientos.Personales.Entities.Plan_Entrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Plan_EntrenamientoRepository extends JpaRepository<Plan_Entrenamiento, Long> {
}
