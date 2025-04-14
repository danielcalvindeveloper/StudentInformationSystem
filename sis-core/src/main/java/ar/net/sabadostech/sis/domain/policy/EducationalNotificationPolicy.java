package ar.net.sabadostech.sis.domain.policy;

import ar.net.sabadostech.sis.domain.policy.context.NotificationContext;
import ar.net.sabadostech.sis.domain.model.NotificationRecipient;
import ar.net.sabadostech.sis.domain.model.StudentRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Política de notificación para situaciones educativas.
 *
 * <p>Según lo indicado en el documento <strong>pedidos-del-colegio.md</strong>,
 * las notificaciones educativas deben enviarse:</p>
 * <ul>
 *     <li>A todos los responsables de los alumnos del curso.</li>
 *     <li>Al docente responsable del curso.</li>
 * </ul>
 *
 * <p>Esta clase implementa esa regla del negocio, extrayendo de {@link NotificationContext}
 * la lista de alumnos del curso actual y el docente responsable, sin aplicar filtros adicionales.</p>
 */
public class EducationalNotificationPolicy implements NotificationPolicy {

    @Override
    public List<NotificationRecipient> determineRecipients(NotificationContext context) {
        if (context == null) return List.of();

        List<NotificationRecipient> recipients = new ArrayList<>();

        if (context.getAllStudentsInGrade() != null) {
            for (StudentRecord record : context.getAllStudentsInGrade()) {
                recipients.addAll(record.getAssignments());
            }
        }

        if (context.getTeacher() != null) {
            recipients.add(context.getTeacher());
        }

        return recipients;
    }
}