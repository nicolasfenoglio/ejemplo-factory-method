package dev.nicofeno.factorymethod;

import dev.nicofeno.infra.ClienteSmsGateway;
import dev.nicofeno.shared.Notificacion;
import dev.nicofeno.shared.NotificacionSms;

import java.util.Objects;

public class NotificadorSms extends Notificador {

    private static NotificadorSms SINGLETON;

    private final ClienteSmsGateway clienteSmsGateway;

    protected NotificadorSms(ClienteSmsGateway clienteSmsGateway) {
        this.clienteSmsGateway = Objects.requireNonNull(
                clienteSmsGateway,
                "El cliente SMS es obligatorio"
        );
    }

    public static Notificador getInstance(final ClienteSmsGateway clienteSmsGateway) {
        if (SINGLETON != null) return SINGLETON;
        SINGLETON = new NotificadorSms(clienteSmsGateway);
        return SINGLETON;
    }

    @Override
    protected Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new NotificacionSms(destinatario, mensaje, clienteSmsGateway);
    }
}
