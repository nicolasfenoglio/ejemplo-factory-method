package dev.nicofeno.shared;

import java.util.Objects;

public class NotificacionWhatsApp implements Notificacion {
    private final String destinatario;
    private final String mensaje;
    private final String apiKey;
    private final String urlApi;

    public NotificacionWhatsApp(
            String destinatario,
            String mensaje,
            String apiKey,
            String urlApi
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
        this.apiKey = Objects.requireNonNull(apiKey, "La API key es obligatoria");
        this.urlApi = Objects.requireNonNull(urlApi, "La URL de API es obligatoria");
        if (this.apiKey.isBlank() || this.urlApi.isBlank()) {
            throw new IllegalArgumentException("La configuración de WhatsApp no es válida");
        }
    }

    @Override
    public void enviar() {
        System.out.printf(
                "WhatsApp %s usando %s enviando a %s: %s%n",
                urlApi,
                apiKey,
                destinatario,
                mensaje
        );
    }
}
