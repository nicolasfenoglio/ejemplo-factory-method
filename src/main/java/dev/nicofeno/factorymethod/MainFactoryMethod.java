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
                NotificadorEmail.getInstance(clienteSmtp),
                "ana@example.com",
                "Tu pedido fue despachado"
        );
        procesarEnvio(
                NotificadorSms.getInstance(clienteSms),
                "+5491155555555",
                "Tu pedido fue entregado"
        );
        procesarEnvio(
                NotificadorWhatsApp.getInstance("WHATSAPP_API_KEY", "https://api.whatsap.com"),
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
