package com.clinica.sistema.usuario.passwordreset;

import com.clinica.sistema.usuario.Usuario;
import com.clinica.sistema.usuario.UsuarioRepository;
import com.clinica.sistema.email.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PasswordResetService {

    private final UsuarioRepository usuarioRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.reset-password-url}")
    private String resetPasswordUrl;

    public PasswordResetService(UsuarioRepository usuarioRepository, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    public void requestPasswordReset(String email) throws MessagingException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            String token = UUID.randomUUID().toString();
            usuario.setResetToken(token);
            usuarioRepository.save(usuario);

            String resetLink = resetPasswordUrl + "?token=" + token;
            emailService.sendEmail(
                    email,
                    "Password Reset Request",
                    "Click the link to reset your password: " + resetLink
            );
        }
    }

    public void resetPassword(String token, String newPassword) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByResetToken(token);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setPassword(passwordEncoder.encode(newPassword));
            usuario.setResetToken(null);
            usuarioRepository.save(usuario);
        }
    }
}
