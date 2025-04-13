package ar.net.sabadostech.sis.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Aggregates student data and associated guardian assignments.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRecord {

    private Student student;
    private Grade currentGrade;
    private List<GuardianAssignment> assignments;

    public static StudentRecord create(
            Student student,
            Grade grade,
            List<GuardianAssignment> assignments,
            Predicate<String> existsStudentRecord) {

        if (existsStudentRecord.test(student.getId())) {
            throw new IllegalStateException("Student already has a record.");
        }

        if (assignments == null || assignments.isEmpty()) {
            throw new IllegalArgumentException("At least one guardian assignment is required.");
        }

        if (grade == null) {
            throw new IllegalArgumentException("Grade must not be null.");
        }

        boolean hasPrimary = assignments.stream().anyMatch(GuardianAssignment::isPrimaryContact);
        if (!hasPrimary) {
            throw new IllegalArgumentException("One primary contact must be specified.");
        }

        long uniqueCount = assignments.stream()
                .map(a -> a.getAdult().getId() + "|" + a.getRole())
                .distinct()
                .count();

        if (uniqueCount < assignments.size()) {
            throw new IllegalArgumentException("Duplicate guardian-role assignments are not allowed.");
        }

        return new StudentRecord(student, grade, assignments);
    }

    public List<NotificationRecipient> getDisciplinaryNotificationRecipients() {
        return assignments.stream()
                .map(GuardianAssignment::getAdult)
                .distinct()
                .map(adult -> (NotificationRecipient) adult)
                .collect(Collectors.toList());
    }
}
