package com.es.Gestion.de.Entrenamientos.Personales.Service;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.UsuarioDTO;
import com.es.Gestion.de.Entrenamientos.Personales.DTO.UsuarioRegisterDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Entities.Usuario;
import com.es.Gestion.de.Entrenamientos.Personales.Repository.UsuarioRepository;
import com.es.Gestion.de.Entrenamientos.Personales.util.UsuarioValidacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.es.Gestion.de.Entrenamientos.Personales.util.Mapper;

import java.util.List;
@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioValidacion usuarioValidacion;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
        UserDetails user = User.builder().username(username).password(usuario.getContrasena()).roles(usuario.getRol()).build();
        return user;
    }

    public UsuarioRegisterDTO registerUser(UsuarioRegisterDTO user) {
        usuarioValidacion.validateUserRegistration(user);

        String encodedPassword = passwordEncoder.encode(user.getContrasena());
        Usuario newUser = new Usuario(user.getNombre(), encodedPassword, user.getRol());
        usuarioRepository.save(newUser);

        return user;
    }

    public UsuarioDTO getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return Mapper.toDTO(usuarios.get(0));
    }

    public UsuarioDTO getUserById(Long id) {
        usuarioValidacion.validateGetUserById(id);
        Usuario user = usuarioRepository.findById(id).orElse(null);
        return Mapper.toDTO(user);
    }

    public UsuarioDTO updateUser(Long id, UsuarioDTO user) {
        usuarioValidacion.validateUpdateUser(id, user);

        Usuario existingUser = usuarioRepository.findById(id).orElse(null);

        existingUser.setNombre(user.getNombre());

        if (user.getContrasena() != null && !user.getContrasena().isEmpty()) {
            existingUser.setContrasena(passwordEncoder.encode(user.getContrasena()));
        }

        existingUser.setRol(user.getRol());
        existingUser.setFecha_creacion(user.getFecha_creacion());
        existingUser.setCorreo(user.getCorreo());

        Usuario updatedUser = usuarioRepository.save(existingUser);

        return Mapper.toDTO(updatedUser);
    }

    public void deleteUser(Long id) {
        usuarioValidacion.validateDeleteUser(id);
        usuarioRepository.deleteById(id);
    }
}

