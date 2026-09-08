package dev.nicofeno.acoplado;

import dev.nicofeno.shared.NotificacionEmail;
import dev.nicofeno.shared.NotificacionSms;
import dev.nicofeno.shared.NotificacionWhatsApp;
import dev.nicofeno.infra.ApiCredentials;
import dev.nicofeno.infra.ClienteSmsGateway;
import dev.nicofeno.infra.ClienteSmtp;
import dev.nicofeno.infra.SmtpConfig;

public class ServicioNotificaciones {
    public void enviarNotificacion(
            CanalNotificacion canal,
            String destinatario,
            String mensaje
    ) {
        if (canal == null) {
            throw new IllegalArgumentException("El canal es obligatorio");
        }
        if (destinatario == null || destinatario.isBlank()) {
            throw new IllegalArgumentException("El destinatario es obligatorio");
        }
        if (mensaje == null || mensaje.isBlank()) {
            throw new IllegalArgumentException("El mensaje es obligatorio");
        }

        switch (canal) {
            case EMAIL -> {
                var smtp = new ClienteSmtp(
                        new SmtpConfig("smtp.example.com", 587, "notificaciones")
                );
                new NotificacionEmail(destinatario, mensaje, smtp).enviar();
            }
            case SMS -> {
                var smsGateway = new ClienteSmsGateway(
                        new ApiCredentials("SMS_API_KEY_123")
                );
                new NotificacionSms(destinatario, mensaje, smsGateway).enviar();
            }
            case WHATSAPP -> new NotificacionWhatsApp(
                    destinatario,
                    mensaje,
                    "WHATSAPP_API_KEY_123",
                    "https://api.whatsapp.com"
            ).enviar();
        }
    }
}
