package ar.net.sabadostech.sis.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Representa la asignación de un adulto responsable a un estudiante con un rol específico.
 */
@AllArgsConstructor
@Getter
public class GuardianAssignment implements NotificationRecipient {

    private final Student student;
    private final ResponsibleAdult adult;
    private final GuardianRole role;
    private final boolean primaryContact;

    @Override
    public String getName() {
        return adult != null ? adult.getFullName() : null;
    }

    @Override
    public String getEmail() {
        return adult != null ? adult.getEmail() : null;
    }

    @Override
    public String getRole() {
        return role != null ? role.name() : null;
    }

    @Override
    public boolean isPrimary() {
        return primaryContact;
    }
}