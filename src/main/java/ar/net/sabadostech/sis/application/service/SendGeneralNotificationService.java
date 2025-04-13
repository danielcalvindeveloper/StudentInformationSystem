package ar.net.sabadostech.sis.application.service;

import ar.net.sabadostech.sis.domain.model.NotificationRecipient;
import ar.net.sabadostech.sis.domain.model.ResponsibleAdult;
import ar.net.sabadostech.sis.domain.model.Teacher;
import ar.net.sabadostech.sis.dto.NotificationRequest;
import ar.net.sabadostech.sis.port.input.SendGeneralNotificationUseCase;
import ar.net.sabadostech.sis.port.output.Notificator;
import ar.net.sabadostech.sis.port.output.ResponsibleAdultRepository;
import ar.net.sabadostech.sis.port.output.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Application service to send a general notification to all teachers and responsible adults.
 */
@RequiredArgsConstructor
public class SendGeneralNotificationService implements SendGeneralNotificationUseCase {

    private static final Logger logger = LoggerFactory.getLogger(SendGeneralNotificationService.class);

    private final ResponsibleAdultRepository adultRepository;
    private final TeacherRepository teacherRepository;
    private final Notificator notificator;

    @Override
    public void execute(NotificationRequest request) {
        List<ResponsibleAdult> adults = adultRepository.findAll();
        List<Teacher> teachers = teacherRepository.findAll();

        Set<NotificationRecipient> recipients = new HashSet<>();
        recipients.addAll(adults);
        recipients.addAll(teachers);

        logger.info("Sending general notification to {} recipients", recipients.size());
        notificator.send(new ArrayList<>(recipients), request);
    }
}
