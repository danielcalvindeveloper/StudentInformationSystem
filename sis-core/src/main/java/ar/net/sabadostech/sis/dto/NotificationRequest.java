package ar.net.sabadostech.sis.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Data transfer object for sending notifications.
 */
@Data
public class NotificationRequest {
    private String subject;
    private String body;
    private LocalDateTime sentAt;
}
