package com.es.Gestion.de.Entrenamientos.Personales.Controller;

import com.es.Gestion.de.Entrenamientos.Personales.DTO.UsuarioLoginDTO;
import com.es.Gestion.de.Entrenamientos.Personales.DTO.UsuarioRegisterDTO;
import com.es.Gestion.de.Entrenamientos.Personales.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(UsuarioLoginDTO usuarioLoginDTO) {
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioLoginDTO.getNombre(), usuarioLoginDTO.getContrasena())
        );
        return authentication.toString();
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioRegisterDTO> register(
            @RequestBody UsuarioRegisterDTO usuarioRegisterDTO) {

        return ResponseEntity.ok(usuarioService.registerUser(usuarioRegisterDTO));
    }
}
