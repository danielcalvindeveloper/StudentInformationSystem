package ar.net.sabadostech.sis.domain.model;

import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Aggregates student data and associated guardian assignments.
 */
@Data
public class StudentRecord {
    private Student student;
    private List<GuardianAssignment> assignments;
    private Grade currentGrade;

    public List<ResponsibleAdult> getDisciplinaryNotificationRecipients() {
        return assignments.stream()
                .map(GuardianAssignment::getAdult)
                .distinct()
                .collect(Collectors.toList());
    }
}
