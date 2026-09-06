package dev.nicofeno.factorymethod;

import dev.nicofeno.shared.Notificacion;

public abstract class Notificador {
    protected abstract Notificacion crearNotificacion(
            String destinatario,
            String mensaje
    );

    public void enviarNotificacion(String destinatario, String mensaje) {
        if (destinatario == null || destinatario.isBlank()) {
            throw new IllegalArgumentException("El destinatario es obligatorio");
        }
        if (mensaje == null || mensaje.isBlank()) {
            throw new IllegalArgumentException("El mensaje es obligatorio");
        }
        Notificacion notificacion = crearNotificacion(destinatario, mensaje);
        notificacion.enviar();
    }
}
