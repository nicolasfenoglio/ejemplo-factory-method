package dev.nicofeno.factorymethod;

import dev.nicofeno.infra.ClienteSmsGateway;
import dev.nicofeno.shared.Notificacion;
import dev.nicofeno.shared.NotificacionSms;

import java.util.Objects;

public class NotificadorSms extends Notificador {
    private final ClienteSmsGateway clienteSmsGateway;

    public NotificadorSms(ClienteSmsGateway clienteSmsGateway) {
        this.clienteSmsGateway = Objects.requireNonNull(
                clienteSmsGateway,
                "El cliente SMS es obligatorio"
        );
    }

    @Override
    protected Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new NotificacionSms(destinatario, mensaje, clienteSmsGateway);
    }
}
