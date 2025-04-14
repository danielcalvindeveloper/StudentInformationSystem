package ar.net.sabadostech.sis.domain.policy;

import ar.net.sabadostech.sis.domain.policy.context.NotificationContext;
import ar.net.sabadostech.sis.domain.model.NotificationRecipient;
import ar.net.sabadostech.sis.domain.model.StudentRecord;
import ar.net.sabadostech.sis.domain.model.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Política de notificación general que debe incluir:
 * <ul>
 *     <li>Todos los responsables de todos los cursos.</li>
 *     <li>Todos los docentes del sistema.</li>
 * </ul>
 *
 * <p>Esta regla está establecida en el documento <strong>pedidos-del-colegio.md</strong>,
 * donde se describe la necesidad de comunicaciones amplias para eventos generales.</p>
 *
 * <p>La política combina la lista de responsables obtenida de todos los {@link StudentRecord}
 * con la lista de {@link Teacher} disponibles en el {@link NotificationContext}.</p>
 */
public class GeneralNotificationPolicy implements NotificationPolicy {

    @Override
    public List<NotificationRecipient> determineRecipients(NotificationContext context) {
        if (context == null) return List.of();

        List<NotificationRecipient> recipients = new ArrayList<>();

        if (context.getAllStudentsInGrade() != null) {
            for (StudentRecord record : context.getAllStudentsInGrade()) {
                recipients.addAll(record.getAssignments());
            }
        }

        if (context.getAllTeachers() != null) {
            recipients.addAll(context.getAllTeachers());
        }

        return recipients;
    }
}