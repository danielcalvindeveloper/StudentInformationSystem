package ar.net.sabadostech.sis.domain.model;

/**
 * Abstracción de dominio que representa a cualquier actor que puede ser notificado.
 */
public interface NotificationRecipient {
    String getName();
    String getEmail();
    String getRole();
    boolean isPrimary();
}