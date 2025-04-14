package ar.net.sabadostech.sis.domain.policy;

import ar.net.sabadostech.sis.domain.model.GuardianAssignment;
import ar.net.sabadostech.sis.domain.model.NotificationRecipient;
import ar.net.sabadostech.sis.domain.policy.context.NotificationContext;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Política de notificación que selecciona únicamente a los responsables
 * que han solicitado recibir notificaciones administrativas.
 *
 * <p>Según el documento <strong>pedidos-del-colegio.md</strong>, se establece:</p>
 * <blockquote>
 *     "Las administrativas las enviamos sólo a las/los responsables que lo piden."
 * </blockquote>
 * 
 * <p>Y en <strong>Gestion-de-la-Comunicacion-Colegios.md</strong> se documenta un caso de uso donde
 * cada responsable puede configurar si desea o no recibir este tipo de comunicaciones.</p>
 * 
 * <p>Esta política filtra los {@link GuardianAssignment} del estudiante según
 * la preferencia declarada en el {@code ResponsibleAdult} asociado.</p>
 */
public class AdministrativeNotificationPolicy implements NotificationPolicy {

    @Override
    public List<NotificationRecipient> determineRecipients(NotificationContext context) {
        if (context == null || context.getStudentRecord() == null) {
            return List.of();
        }

        return context.getStudentRecord().getAssignments().stream()
            .filter(a -> a.getAdult() != null && a.getAdult().wantsAdministrativeNotifications())
            .collect(Collectors.toList());
    }
}