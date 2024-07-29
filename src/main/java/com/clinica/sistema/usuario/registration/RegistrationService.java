package com.clinica.sistema.usuario.registration;

import com.clinica.sistema.usuario.Role;
import com.clinica.sistema.usuario.Usuario;
import com.clinica.sistema.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class RegistrationService {

    private final UsuarioService userService;

    public String register(RegistrationRequest request) {
        Usuario newUser = new Usuario(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                Role.USER
        );

        return userService.registerUser(newUser);
    }
}