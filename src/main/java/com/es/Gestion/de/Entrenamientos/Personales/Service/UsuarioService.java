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

import java.util.ArrayList;
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
        Usuario newUser = new Usuario(user.getNombre(), encodedPassword, user.getCorreo(), user.getRol(), user.getFecha_creacion());
        usuarioRepository.save(newUser);

        return user;
    }

    public List<UsuarioDTO> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();

        usuarios.forEach(usuario -> {
            UsuarioDTO usuarioDTO = Mapper.toDTO(usuario);
            usuarioDTOs.add(usuarioDTO);
        });

        return usuarioDTOs;
    }


    public UsuarioDTO getUserById(Long id) {
        usuarioValidacion.validateGetUserById(id);
        Usuario user = usuarioRepository.findById(id).orElse(null);
        return Mapper.toDTO(user);
    }

    public UsuarioDTO updateUser(Long id, UsuarioDTO user) {
        usuarioValidacion.validateUpdateUser(id, user);

        Usuario existingUser = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        existingUser.setNombre(user.getNombre());
        existingUser.setContrasena(passwordEncoder.encode(user.getContrasena()));
        existingUser.setRol(user.getRol());
        existingUser.setCorreo(user.getCorreo());
        existingUser.setFecha_creacion(user.getFecha_creacion());

        usuarioRepository.save(existingUser);
        return Mapper.toDTO(existingUser);
    }

    public void deleteUser(Long id) {
        usuarioValidacion.validateDeleteUser(id);
        usuarioRepository.deleteById(id);
    }
}

