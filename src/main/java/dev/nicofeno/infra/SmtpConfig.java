package dev.nicofeno.infra;

public record SmtpConfig(String host, int port, String username) {
    public SmtpConfig {
        if (host == null || host.isBlank()) {
            throw new IllegalArgumentException("El host SMTP es obligatorio");
        }
        if (port < 1 || port > 65535) {
            throw new IllegalArgumentException("El puerto SMTP no es válido");
        }
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("El usuario SMTP es obligatorio");
        }
    }
}
