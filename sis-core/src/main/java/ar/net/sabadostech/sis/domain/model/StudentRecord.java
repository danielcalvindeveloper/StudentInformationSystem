package ar.net.sabadostech.sis.domain.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Getter
public class StudentRecord {

    private final Student student;
    private final Grade grade;
    private final List<GuardianAssignment> assignments;
    private final Predicate<String> existenceCheck;

    private StudentRecord(Student student, Grade grade, List<GuardianAssignment> assignments, Predicate<String> existenceCheck) {
        this.student = student;
        this.grade = grade;
        this.assignments = assignments;
        this.existenceCheck = existenceCheck;
    }

    public static StudentRecord create(Student student, Grade grade, List<GuardianAssignment> assignments, Predicate<String> existenceCheck) {
        return new StudentRecord(student, grade, assignments, existenceCheck);
    }

    /**
     * Retorna los responsables asignados como destinatarios de notificaciones.
     */
    public List<NotificationRecipient> getAssignedGuardians() {
        return new ArrayList<>(assignments);
    }
}