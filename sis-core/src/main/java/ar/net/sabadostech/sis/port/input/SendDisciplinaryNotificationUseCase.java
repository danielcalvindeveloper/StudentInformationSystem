package ar.net.sabadostech.sis.port.input;

import ar.net.sabadostech.sis.dto.NotificationRequest;

/**
 * Input port for sending disciplinary notifications.
 */
public interface SendDisciplinaryNotificationUseCase {
    void execute(String studentId, NotificationRequest request);
}
