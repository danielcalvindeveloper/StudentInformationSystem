package ar.net.sabadostech.sis.domain.model;

import lombok.Data;

/**
 * Represents a teacher who may be assigned to one or more subjects.
 */
@Data
public class Teacher implements NotificationRecipient {
    private String id;
    private String fullName;
    private String email;
}
