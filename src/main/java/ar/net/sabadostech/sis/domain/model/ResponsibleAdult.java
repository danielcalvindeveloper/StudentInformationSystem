package ar.net.sabadostech.sis.domain.model;

import lombok.Data;

/**
 * Represents an adult responsible for a student.
 */
@Data
public class ResponsibleAdult implements NotificationRecipient {
    private String id;
    private String fullName;
    private String phone;
    private String email;
}
