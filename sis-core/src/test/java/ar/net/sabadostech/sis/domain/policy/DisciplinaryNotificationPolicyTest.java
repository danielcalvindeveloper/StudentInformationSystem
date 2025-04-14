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

public class DisciplinaryNotificationPolicyTest {

	private IdSequenceService sequenceService;
	
	@BeforeEach
	public void before() {
		 sequenceService = new InMemoryIdSequenceService();
	}
    @Test
    public void testDetermineRecipients_returnsAllAssignments() {
        ResponsibleAdult adult1 = new ResponsibleAdult("María López", "maria@mail.com", "123", false, true);
        ResponsibleAdult adult2 = new ResponsibleAdult("Carlos Pérez", "carlos@mail.com", "456", false, true);

        GuardianAssignment a1 = new GuardianAssignment(null, adult1, GuardianRole.MOTHER, false);
        GuardianAssignment a2 = new GuardianAssignment(null, adult2, GuardianRole.FATHER, false);

        StudentRecord record = StudentRecord.create(StudentId.generate(sequenceService.next("STU")), null, null, List.of(a1, a2), id -> false);
        NotificationContext context = NotificationContextFactory.forStudent(record);

        var policy = new DisciplinaryNotificationPolicy();
        List<NotificationRecipient> recipients = policy.determineRecipients(context);

        assertEquals(2, recipients.size());
        assertTrue(recipients.contains(a1));
        assertTrue(recipients.contains(a2));
    }
}