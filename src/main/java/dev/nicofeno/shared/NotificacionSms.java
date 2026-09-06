package dev.nicofeno.shared;

import dev.nicofeno.infra.ClienteSmsGateway;

import java.util.Objects;

public class NotificacionSms implements Notificacion {
    private final String destinatario;
    private final String mensaje;
    private final ClienteSmsGateway clienteSmsGateway;

    public NotificacionSms(
            String destinatario,
            String mensaje,
            ClienteSmsGateway clienteSmsGateway
    ) {
        if (destinatario == null
                || !destinatario.matches("^\\+[1-9]\\d{7,14}$")) {
            throw new IllegalArgumentException("El teléfono no tiene formato E.164");
        }
        if (mensaje == null || mensaje.isBlank()) {
            throw new IllegalArgumentException("El mensaje no puede estar vacío");
        }
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.clienteSmsGateway = Objects.requireNonNull(
                clienteSmsGateway,
                "El cliente SMS es obligatorio"
        );
    }

    @Override
    public void enviar() {
        clienteSmsGateway.enviar(destinatario, mensaje);
    }
}
