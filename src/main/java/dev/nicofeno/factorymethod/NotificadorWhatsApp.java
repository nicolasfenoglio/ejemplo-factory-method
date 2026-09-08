package dev.nicofeno.factorymethod;

import dev.nicofeno.shared.Notificacion;
import dev.nicofeno.shared.NotificacionWhatsApp;

import java.util.Objects;

public class NotificadorWhatsApp extends Notificador {

    private static NotificadorWhatsApp SINGLETON;

    private final String apiKey;
    private final String urlApi;

    protected NotificadorWhatsApp(String apiKey, String urlApi) {
        this.apiKey = Objects.requireNonNull(apiKey, "La API key es obligatoria");
        this.urlApi = Objects.requireNonNull(urlApi, "La URL de API es obligatoria");
        if (apiKey.isBlank() || urlApi.isBlank()) {
            throw new IllegalArgumentException("La configuración de WhatsApp no es válida");
        }
    }

    public static Notificador getInstance(final String apiKey, final String urlApi) {
        if (SINGLETON != null) return SINGLETON;
        SINGLETON = new NotificadorWhatsApp(apiKey, urlApi);
        return SINGLETON;
    }

    @Override
    protected Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new NotificacionWhatsApp(destinatario, mensaje, apiKey, urlApi);
    }
}
