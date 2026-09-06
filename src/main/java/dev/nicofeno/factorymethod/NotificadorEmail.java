package dev.nicofeno.factorymethod;

import dev.nicofeno.infra.ClienteSmtp;
import dev.nicofeno.shared.Notificacion;
import dev.nicofeno.shared.NotificacionEmail;

import java.util.Objects;

public class NotificadorEmail extends Notificador {
    private final ClienteSmtp clienteSmtp;

    public NotificadorEmail(ClienteSmtp clienteSmtp) {
        this.clienteSmtp = Objects.requireNonNull(
                clienteSmtp,
                "El cliente SMTP es obligatorio"
        );
    }

    @Override
    protected Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new NotificacionEmail(destinatario, mensaje, clienteSmtp);
    }
}
