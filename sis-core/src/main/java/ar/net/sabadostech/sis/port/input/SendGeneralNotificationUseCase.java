package ar.net.sabadostech.sis.port.input;

import ar.net.sabadostech.sis.dto.NotificationRequest;

/**
 * Input port for sending general notifications to the entire community.
 */
public interface SendGeneralNotificationUseCase {
    void execute(NotificationRequest request);
}
