package dev.nicofeno.factorymethod;

import dev.nicofeno.shared.Notificacion;
import dev.nicofeno.shared.NotificacionWhatsApp;

import java.util.Objects;

public class NotificadorWhatsApp extends Notificador {
    private final String apiKey;
    private final String urlApi;

    public NotificadorWhatsApp(String apiKey, String urlApi) {
        this.apiKey = Objects.requireNonNull(apiKey, "La API key es obligatoria");
        this.urlApi = Objects.requireNonNull(urlApi, "La URL de API es obligatoria");
        if (apiKey.isBlank() || urlApi.isBlank()) {
            throw new IllegalArgumentException("La configuración de WhatsApp no es válida");
        }
    }

    @Override
    protected Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new NotificacionWhatsApp(destinatario, mensaje, apiKey, urlApi);
    }
}
