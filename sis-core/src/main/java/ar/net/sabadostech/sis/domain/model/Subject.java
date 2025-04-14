package ar.net.sabadostech.sis.domain.model;

import lombok.Data;

/**
 * Represents a subject taught in a grade, assigned to a teacher.
 */
@Data
public class Subject {
    private String id;
    private String name;
    private Teacher assignedTeacher;
}
