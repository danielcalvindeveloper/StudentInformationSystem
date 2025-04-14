package ar.net.sabadostech.sis.domain.policy;

import ar.net.sabadostech.sis.domain.model.*;
import ar.net.sabadostech.sis.domain.policy.context.NotificationContext;
import ar.net.sabadostech.sis.domain.policy.context.NotificationContextFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EducationalNotificationPolicyTest {

    @Test
    public void testDetermineRecipients_includesAllResponsiblesAndTeacher() {
        ResponsibleAdult adult1 = new ResponsibleAdult("María López", "maria@mail.com", "123", false, true);
        ResponsibleAdult adult2 = new ResponsibleAdult("Carlos Pérez", "carlos@mail.com", "456", false, true);

        GuardianAssignment a1 = new GuardianAssignment(null, adult1, GuardianRole.MOTHER, false);
        GuardianAssignment a2 = new GuardianAssignment(null, adult2, GuardianRole.FATHER, false);

        StudentRecord student1 = StudentRecord.create(null, null, List.of(a1), id -> false);
        StudentRecord student2 = StudentRecord.create(null, null, List.of(a2), id -> false);

        Teacher teacher = new Teacher("Prof. Ana", "ana@colegio.com", "Matemática");

        NotificationContext context = NotificationContextFactory.forTeacherAndStudents(teacher, List.of(student1, student2));

        EducationalNotificationPolicy policy = new EducationalNotificationPolicy();
        List<NotificationRecipient> recipients = policy.determineRecipients(context);

        assertEquals(3, recipients.size());
        assertTrue(recipients.contains(a1));
        assertTrue(recipients.contains(a2));
        assertTrue(recipients.contains(teacher));
    }
}