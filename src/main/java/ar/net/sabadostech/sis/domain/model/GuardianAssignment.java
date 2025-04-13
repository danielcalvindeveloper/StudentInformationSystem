package ar.net.sabadostech.sis.domain.model;

import lombok.Data;

/**
 * Represents the assignment of a responsible adult to a student, with a defined role.
 */
@Data
public class GuardianAssignment {
    private Student student;
    private ResponsibleAdult adult;
    private GuardianRole role;
    private boolean primaryContact;
}
