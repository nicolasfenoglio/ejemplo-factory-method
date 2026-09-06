package dev.nicofeno.shared;

import dev.nicofeno.infra.ClienteSmtp;

import java.util.Objects;

public class NotificacionEmail implements Notificacion {
    private final String destinatario;
    private final String mensaje;
    private final ClienteSmtp clienteSmtp;

    public NotificacionEmail(
            String destinatario,
            String mensaje,
            ClienteSmtp clienteSmtp
    ) {
        if (destinatario == null
                || !destinatario.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("El email no tiene un formato válido");
        }
        if (mensaje == null || mensaje.isBlank()) {
            throw new IllegalArgumentException("El mensaje no puede estar vacío");
        }
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.clienteSmtp = Objects.requireNonNull(
                clienteSmtp,
                "El cliente SMTP es obligatorio"
        );
    }

    @Override
    public void enviar() {
        clienteSmtp.enviar(destinatario, mensaje);
    }
}
