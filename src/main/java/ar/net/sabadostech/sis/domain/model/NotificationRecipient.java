package ar.net.sabadostech.sis.domain.model;

/**
 * Marker interface for all notification recipients.
 */
public interface NotificationRecipient {
    String getEmail();
    String getFullName();
}
