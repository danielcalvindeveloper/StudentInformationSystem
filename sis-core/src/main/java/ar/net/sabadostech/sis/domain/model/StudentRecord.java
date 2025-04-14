package ar.net.sabadostech.sis.domain.model;

import lombok.Getter;

import java.util.List;
import java.util.function.Predicate;

/**
 * Representa el agregado principal de un estudiante, incluyendo su identidad,
 * grado actual y responsables asignados.
 */
@Getter
public class StudentRecord {

    private final StudentId id;
    private final Student student;
    private final Grade grade;
    private final List<GuardianAssignment> assignments;
    private final Predicate<String> existenceCheck;

    private StudentRecord(StudentId id, Student student, Grade grade, List<GuardianAssignment> assignments, Predicate<String> existenceCheck) {
        this.id = id;
        this.student = student;
        this.grade = grade;
        this.assignments = assignments;
        this.existenceCheck = existenceCheck;
    }

    /**
     * Fábrica de creación de un StudentRecord con todos los datos requeridos.
     */
    public static StudentRecord create(StudentId id, Student student, Grade grade, List<GuardianAssignment> assignments, Predicate<String> existenceCheck) {
        return new StudentRecord(id, student, grade, assignments, existenceCheck);
    }

    /**
     * Retorna todos los responsables asignados como destinatarios.
     */
    public List<NotificationRecipient> getAssignedGuardians() {
        return List.copyOf(assignments);
    }
}