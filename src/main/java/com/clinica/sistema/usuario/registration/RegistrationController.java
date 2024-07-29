package com.clinica.sistema.usuario.registration;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/register")
@AllArgsConstructor
@Tag(name = "Registro", description = "Gerenciamento dos registros de usuários")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    @Operation(summary = "Registrar usuário", description = "Registra um novo usuário no sistema")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
}
