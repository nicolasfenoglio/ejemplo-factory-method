package dev.nicofeno.infra;

import java.util.Objects;

public final class ClienteSmsGateway {
    private final ApiCredentials credentials;

    public ClienteSmsGateway(ApiCredentials credentials) {
        // Validaciones de infraestructura: credenciales presentes y gateway
        // autenticado/disponible corresponden a este adaptador técnico.
        this.credentials = Objects.requireNonNull(
                credentials,
                "Las credenciales del gateway SMS son obligatorias"
        );
    }

    public void enviar(String destinatario, String mensaje) {
        System.out.printf(
                "Gateway SMS (%s) enviando a %s: %s%n",
                credentials.apiKey(),
                destinatario,
                mensaje
        );
    }
}
