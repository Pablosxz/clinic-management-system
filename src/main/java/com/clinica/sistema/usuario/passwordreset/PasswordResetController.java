package com.clinica.sistema.usuario.passwordreset;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/password-reset")
@AllArgsConstructor
@Tag(name = "PasswordReset", description = "Gerenciamento das senhas")
public class PasswordResetController {

    private final PasswordResetService passwordResetService;

    @PostMapping("/request")
    @Operation(summary = "Requisitar reset", description = "Realiza a requisição de troca/reset de senha via email")
    @ResponseStatus(HttpStatus.OK)
    public void requestPasswordReset(@RequestParam String email) throws MessagingException {
        passwordResetService.requestPasswordReset(email);
    }

    @PostMapping("/reset")
    @Operation(summary = "Realizar reset", description = "Realiza o reset da senha no sistema com o token gerado na requisição")
    @ResponseStatus(HttpStatus.OK)
    public void resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        passwordResetService.resetPassword(token, newPassword);
    }
}
