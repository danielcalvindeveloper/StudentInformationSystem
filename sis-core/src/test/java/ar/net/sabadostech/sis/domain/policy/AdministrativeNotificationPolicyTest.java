package ar.net.sabadostech.sis.domain.policy;

import ar.net.sabadostech.sis.domain.model.*;
import ar.net.sabadostech.sis.domain.policy.context.NotificationContext;
import ar.net.sabadostech.sis.domain.policy.context.NotificationContextFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdministrativeNotificationPolicyTest {

    @Test
    public void testDetermineRecipients_onlySubscribedAdults() {
        ResponsibleAdult adult1 = new ResponsibleAdult("María López", "maria@mail.com", "123", false, true);
        ResponsibleAdult adult2 = new ResponsibleAdult("Carlos Pérez", "carlos@mail.com", "456", false, false);

        GuardianAssignment a1 = new GuardianAssignment(null, adult1, GuardianRole.MOTHER, false);
        GuardianAssignment a2 = new GuardianAssignment(null, adult2, GuardianRole.FATHER, false);

        StudentRecord record = StudentRecord.create(null, null, List.of(a1, a2), id -> false);
        NotificationContext context = NotificationContextFactory.forStudent(record);

        var policy = new AdministrativeNotificationPolicy();
        List<NotificationRecipient> recipients = policy.determineRecipients(context);

        assertEquals(1, recipients.size());
        assertTrue(recipients.contains(a1));
        assertFalse(recipients.contains(a2));
    }
}