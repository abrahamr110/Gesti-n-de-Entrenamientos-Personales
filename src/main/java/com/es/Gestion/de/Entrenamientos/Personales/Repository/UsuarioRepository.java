package com.es.Gestion.de.Entrenamientos.Personales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
