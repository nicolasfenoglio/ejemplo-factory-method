package dev.nicofeno.acoplado;

public class MainAcoplado {
    public static void main(String[] args) {
        var servicio = new ServicioNotificacionesAcoplado();

        servicio.enviarNotificacion(
                CanalNotificacion.EMAIL,
                "ana@example.com",
                "Tu pedido fue despachado"
        );
        servicio.enviarNotificacion(
                CanalNotificacion.SMS,
                "+5491155555555",
                "Tu pedido fue entregado"
        );
        servicio.enviarNotificacion(
                CanalNotificacion.WHATSAPP,
                "+5491155555555",
                "Tu pedido esta listo para retirar"
        );
    }
}
