package dev.nicofeno.factorymethod;

import dev.nicofeno.infra.ClienteSmtp;
import dev.nicofeno.shared.Notificacion;
import dev.nicofeno.shared.NotificacionEmail;

import java.util.Objects;

public class NotificadorEmail extends Notificador {

    private static NotificadorEmail SINGLETON;

    private final ClienteSmtp clienteSmtp;

    protected NotificadorEmail(final ClienteSmtp clienteSmtp) {
        this.clienteSmtp = Objects.requireNonNull(
                clienteSmtp,
                "El cliente SMTP es obligatorio"
        );
    }

    public static Notificador getInstance(final ClienteSmtp clienteSmtp) {
        if (SINGLETON != null) return SINGLETON;
        SINGLETON = new NotificadorEmail(clienteSmtp);
        return SINGLETON;
    }

    @Override
    protected Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new NotificacionEmail(destinatario, mensaje, clienteSmtp);
    }
}
