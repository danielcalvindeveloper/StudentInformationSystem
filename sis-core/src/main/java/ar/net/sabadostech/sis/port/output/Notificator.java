package ar.net.sabadostech.sis.port.output;

import ar.net.sabadostech.sis.domain.model.NotificationRecipient;
import ar.net.sabadostech.sis.dto.NotificationRequest;

import java.util.List;

/**
 * Output port for sending notifications to recipients.
 */
public interface Notificator {
    void send(List<NotificationRecipient> recipients, NotificationRequest request);
}
