package dev.nicofeno.infra;

import java.util.Objects;

public final class ClienteSmtp {
    private final SmtpConfig config;

    public ClienteSmtp(SmtpConfig config) {
        // Validaciones de infraestructura: configuración completa y servidor
        // disponible deberían verificarse aquí o mediante un health check.
        this.config = Objects.requireNonNull(config, "La configuración SMTP es obligatoria");
    }

    public void enviar(String destinatario, String mensaje) {
        System.out.printf(
                "SMTP %s:%d enviando email a %s: %s%n",
                config.host(),
                config.port(),
                destinatario,
                mensaje
        );
    }
}
