package ar.net.sabadostech.sis.domain.policy;

import ar.net.sabadostech.sis.domain.model.*;
import ar.net.sabadostech.sis.domain.policy.context.NotificationContext;
import ar.net.sabadostech.sis.domain.policy.context.NotificationContextFactory;
import ar.net.sabadostech.sis.domain.service.IdSequenceService;
import ar.net.sabadostech.sis.infrastructure.sequence.InMemoryIdSequenceService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GeneralNotificationPolicyTest {

	private IdSequenceService sequenceService;
	
	@BeforeEach
	public void before() {
		 sequenceService = new InMemoryIdSequenceService();
	}
	
    @Test
    public void testDetermineRecipients_includesAllResponsiblesAndAllTeachers() {
        ResponsibleAdult adult1 = new ResponsibleAdult("María López", "maria@mail.com", "123", false, true);
        ResponsibleAdult adult2 = new ResponsibleAdult("Carlos Pérez", "carlos@mail.com", "456", false, true);

        GuardianAssignment a1 = new GuardianAssignment(null, adult1, GuardianRole.MOTHER, false);
        GuardianAssignment a2 = new GuardianAssignment(null, adult2, GuardianRole.FATHER, false);

        StudentRecord student1 = StudentRecord.create(StudentId.generate(sequenceService.next("STU")), null, null, List.of(a1), id -> false);
        StudentRecord student2 = StudentRecord.create(StudentId.generate(sequenceService.next("STU")),null, null, List.of(a2), id -> false);

        Teacher teacher1 = new Teacher(TeacherId.generate(sequenceService.next("TCH")),"Prof. Ana", "ana@colegio.com", "Lengua");
        Teacher teacher2 = new Teacher(TeacherId.generate(sequenceService.next("TCH")),"Prof. Luis", "luis@colegio.com", "Historia");

        NotificationContext context = NotificationContextFactory.forAllSystemWide(List.of(student1, student2), List.of(teacher1, teacher2));

        GeneralNotificationPolicy policy = new GeneralNotificationPolicy();
        List<NotificationRecipient> recipients = policy.determineRecipients(context);

        assertEquals(4, recipients.size());
        assertTrue(recipients.contains(a1));
        assertTrue(recipients.contains(a2));
        assertTrue(recipients.contains(teacher1));
        assertTrue(recipients.contains(teacher2));
    }
}