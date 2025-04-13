package ar.net.sabadostech.sis.application.service;

import ar.net.sabadostech.sis.domain.exception.StudentNotFoundException;
import ar.net.sabadostech.sis.domain.model.*;
import ar.net.sabadostech.sis.dto.NotificationRequest;
import ar.net.sabadostech.sis.port.output.Notificator;
import ar.net.sabadostech.sis.port.output.StudentRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit test for SendDisciplinaryNotificationService.
 */
public class SendDisciplinaryNotificationServiceTest {

    private StudentRecordRepository studentRecordRepository;
    private Notificator notificator;
    private SendDisciplinaryNotificationService service;

    @BeforeEach
    void setUp() {
        studentRecordRepository = mock(StudentRecordRepository.class);
        notificator = mock(Notificator.class);
        service = new SendDisciplinaryNotificationService(studentRecordRepository, notificator);
    }

    @Test
    void shouldSendNotificationToResponsibleAdults() {
        Student student = new Student();
        student.setId("S1");
        student.setFullName("Test Student");
        student.setDateOfBirth(LocalDate.of(2010, 1, 1));

        ResponsibleAdult adult = new ResponsibleAdult();
        adult.setId("RA1");
        adult.setFullName("Responsible Adult");
        adult.setEmail("adult@example.com");

        GuardianAssignment assignment = new GuardianAssignment();
        assignment.setStudent(student);
        assignment.setAdult(adult);
        assignment.setRole(GuardianRole.MOTHER);
        assignment.setPrimaryContact(true);

        StudentRecord record = new StudentRecord();
        record.setStudent(student);
        record.setAssignments(List.of(assignment));

        when(studentRecordRepository.findByStudentId("S1")).thenReturn(Optional.of(record));

        NotificationRequest request = new NotificationRequest();
        request.setSubject("Disciplinary Alert");
        request.setBody("The student has been involved in an incident.");
        request.setSentAt(LocalDateTime.now());

        service.execute("S1", request);

        verify(notificator, times(1)).send(eq(List.of(adult)), eq(request));
    }

    @Test
    void shouldThrowExceptionWhenStudentNotFound() {
        when(studentRecordRepository.findByStudentId("UNKNOWN")).thenReturn(Optional.empty());

        NotificationRequest request = new NotificationRequest();
        request.setSubject("Disciplinary Alert");

        assertThrows(StudentNotFoundException.class, () -> service.execute("UNKNOWN", request));
    }
}
