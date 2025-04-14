package ar.net.sabadostech.sis.domain.policy;

import ar.net.sabadostech.sis.domain.model.NotificationRecipient;
import ar.net.sabadostech.sis.domain.policy.context.NotificationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Política que selecciona a todos los responsables del estudiante,
 * independientemente de su preferencia de notificación.
 */
public class DisciplinaryNotificationPolicy implements NotificationPolicy {

	@Override
	public List<NotificationRecipient> determineRecipients(NotificationContext context) {
	    if (context == null || context.getStudentRecord() == null) {
	        return List.of(); // defensivo ante nulos
	    }
	    return new ArrayList<>(context.getStudentRecord().getAssignments());
	}

}