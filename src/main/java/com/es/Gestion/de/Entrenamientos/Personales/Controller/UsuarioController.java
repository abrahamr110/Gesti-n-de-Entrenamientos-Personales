package com.es.Gestion.de.Entrenamientos.Personales.Controller;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.UsuarioDTO;
import com.es.Gestion.de.Entrenamientos.Personales.DTO.UsuarioLoginDTO;
import com.es.Gestion.de.Entrenamientos.Personales.DTO.UsuarioRegisterDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(UsuarioLoginDTO usuarioLoginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioLoginDTO.getNombre(), usuarioLoginDTO.getContrasena())
        );
        return authentication.toString();
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioRegisterDTO> register(
            @RequestBody UsuarioRegisterDTO usuarioRegisterDTO
    ) {
        try {
            return ResponseEntity.ok(usuarioService.registerUser(usuarioRegisterDTO));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/")
    public ResponseEntity<UsuarioDTO> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }
}

