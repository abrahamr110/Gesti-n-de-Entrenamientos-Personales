package com.es.Gestion.de.Entrenamientos.Personales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Optional<Usuario> findByUsername(String nombre);
}
