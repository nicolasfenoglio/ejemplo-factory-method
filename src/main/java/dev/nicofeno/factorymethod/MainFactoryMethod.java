package dev.nicofeno.factorymethod;

import dev.nicofeno.infra.ApiCredentials;
import dev.nicofeno.infra.ClienteSmsGateway;
import dev.nicofeno.infra.ClienteSmtp;
import dev.nicofeno.infra.SmtpConfig;

public class MainFactoryMethod {
    public static void main(String[] args) {
        var clienteSmtp = new ClienteSmtp(
                new SmtpConfig("smtp.example.com", 587, "notificaciones")
        );
        var clienteSms = new ClienteSmsGateway(
                new ApiCredentials("SMS_API_KEY_123")
        );

        procesarEnvio(
                new NotificadorEmail(clienteSmtp),
                "ana@example.com",
                "Tu pedido fue despachado"
        );
        procesarEnvio(
                new NotificadorSms(clienteSms),
                "+5491155555555",
                "Tu pedido fue entregado"
        );
        procesarEnvio(
                new NotificadorWhatsApp(
                        "WHATSAPP_API_KEY_123",
                        "https://api.whatsapp.com"
                ),
                "+5491155555555",
                "Tu pedido esta listo para retirar"
        );
    }

    private static void procesarEnvio(
            Notificador notificador,
            String destinatario,
            String mensaje
    ) {
        notificador.enviarNotificacion(destinatario, mensaje);
    }
}
