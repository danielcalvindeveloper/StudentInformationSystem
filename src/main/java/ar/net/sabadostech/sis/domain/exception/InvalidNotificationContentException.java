package ar.net.sabadostech.sis.domain.exception;

/**
 * Exception thrown when notification content is invalid or incomplete.
 */
public class InvalidNotificationContentException extends RuntimeException {
    public InvalidNotificationContentException() {
        super("Notification content is invalid or empty");
    }
}
