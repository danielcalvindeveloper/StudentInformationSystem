package ar.net.sabadostech.sis.application.service;

import ar.net.sabadostech.sis.domain.exception.StudentNotFoundException;
import ar.net.sabadostech.sis.domain.model.NotificationRecipient;
import ar.net.sabadostech.sis.domain.model.ResponsibleAdult;
import ar.net.sabadostech.sis.domain.model.StudentRecord;
import ar.net.sabadostech.sis.dto.NotificationRequest;
import ar.net.sabadostech.sis.port.output.StudentRecordRepository;
import ar.net.sabadostech.sis.port.output.Notificator;
import ar.net.sabadostech.sis.port.input.SendDisciplinaryNotificationUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Application service for sending disciplinary notifications to responsible adults of a student.
 */
@RequiredArgsConstructor
public class SendDisciplinaryNotificationService implements SendDisciplinaryNotificationUseCase {

    private static final Logger logger = LoggerFactory.getLogger(SendDisciplinaryNotificationService.class);

    private final StudentRecordRepository studentRecordRepository;
    private final Notificator notificator;

    @Override
    public void execute(String studentId, NotificationRequest request) {
        logger.info("Sending disciplinary notification for student ID: {}", studentId);
        StudentRecord record = studentRecordRepository.findByStudentId(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));

        List<NotificationRecipient> recipients = record.getDisciplinaryNotificationRecipients().stream()
    .map(adult -> (NotificationRecipient) adult)
    .collect(Collectors.toList());
        notificator.send(recipients, request);
    }
}
