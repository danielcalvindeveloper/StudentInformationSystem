package ar.net.sabadostech.sis.domain.policy;

import ar.net.sabadostech.sis.domain.model.NotificationRecipient;
import ar.net.sabadostech.sis.domain.policy.context.NotificationContext;

import java.util.List;

/**
 * Contrato que define una política de selección de destinatarios para un tipo específico de notificación.
 * 
 * Cada implementación representa una regla del negocio que determina a quién se debe notificar
 * según el tipo de evento y el contexto provisto.
 */
public interface NotificationPolicy {

    /**
     * Determina los destinatarios de la notificación, según las reglas específicas de esta política.
     *
     * @param context el contexto que contiene información relevante como estudiante, grado o curso
     * @return lista de destinatarios que deben ser notificados
     */
    List<NotificationRecipient> determineRecipients(NotificationContext context);
}