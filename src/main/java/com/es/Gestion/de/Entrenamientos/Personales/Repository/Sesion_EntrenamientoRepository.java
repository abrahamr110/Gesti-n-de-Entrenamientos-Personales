package com.es.Gestion.de.Entrenamientos.Personales.Repository;

import com.es.Gestion.de.Entrenamientos.Personales.Entities.Sesion_Entrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface Sesion_EntrenamientoRepository extends JpaRepository<Sesion_Entrenamiento, Long> {
}
