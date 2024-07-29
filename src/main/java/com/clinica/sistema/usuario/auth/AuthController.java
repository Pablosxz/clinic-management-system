package com.clinica.sistema.usuario.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
@Tag(name = "Autenticação", description = "Gerenciamento da autenticação")
public class AuthController {

    @PostMapping("/login")
    @Operation(summary = "Fazer login", description = "Realiza o login de um usuário no sistema",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Credenciais de login",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = LoginRequest.class),
                            examples = @ExampleObject(
                                    name = "Exemplo de Login",
                                    value = "{ \"username\": \"user@example.com\", \"password\": \"password\" }"
                            )
                    )
            ))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login bem-sucedido"),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    })
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    @PostMapping("/logout")
    @Operation(summary = "Fazer logout", description = "Realiza o logout de um usuário no sistema")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout() {
        SecurityContextHolder.clearContext();
    }

    @GetMapping("/current")
    @Operation(summary = "Usuário atual", description = "Retorna o usuário autenticado atualmente no sistema por meio dos cookies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário autenticado retornado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Usuário não autenticado")
    })
    public Authentication currentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
