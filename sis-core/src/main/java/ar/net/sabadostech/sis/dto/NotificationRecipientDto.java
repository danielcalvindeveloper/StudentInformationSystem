package ar.net.sabadostech.sis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object (DTO) que representa un destinatario de notificación.
 * 
 * <p>Este DTO es utilizado para transportar la información esencial de contacto 
 * de un responsable (tutor, madre, padre, etc.) a los mecanismos de notificación 
 * del sistema, por ejemplo servicios de correo electrónico o mensajería.</p>
 * 
 * <p>No forma parte del modelo de dominio puro porque no representa un concepto 
 * central con lógica o reglas de negocio. Su objetivo principal es actuar como 
 * una estructura de datos de salida o para propósitos de integración entre capas.</p>
 * 
 * <p>Se ubica en el paquete {@code ar.net.sabadostech.sis.dto} como convención para 
 * los objetos transportables entre casos de uso, controladores y adaptadores externos.</p>
 * 
 * <p>En una arquitectura hexagonal, este DTO se genera a partir de entidades del dominio 
 * (como {@code GuardianAssignment}) mediante un mapper o método de transformación específico.</p>
 */
@Data
@AllArgsConstructor
public class NotificationRecipientDto {

    private String fullName;
    private String email;
    private String phone;
}
