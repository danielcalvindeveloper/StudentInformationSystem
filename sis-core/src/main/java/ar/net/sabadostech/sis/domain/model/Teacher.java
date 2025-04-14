package ar.net.sabadostech.sis.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Representa a un docente que puede ser notificado.
 */
@AllArgsConstructor
@Getter
public class Teacher implements NotificationRecipient {

    private final TeacherId id;
    private final String fullName;
    private final String institutionalEmail;
    private final String subject;

    @Override
    public String getName() {
        return fullName;
    }

    @Override
    public String getEmail() {
        return institutionalEmail;
    }

    @Override
    public String getRole() {
        return "TEACHER_" + subject.toUpperCase();
    }

    @Override
    public boolean isPrimary() {
        return true;
    }
}