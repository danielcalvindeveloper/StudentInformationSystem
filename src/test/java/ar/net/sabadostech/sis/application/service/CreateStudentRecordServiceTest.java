package ar.net.sabadostech.sis.application.service;

import ar.net.sabadostech.sis.domain.model.*;
import ar.net.sabadostech.sis.dto.CreateStudentRecordRequest;
import ar.net.sabadostech.sis.dto.GuardianDto;
import ar.net.sabadostech.sis.port.output.GradeRepository;
import ar.net.sabadostech.sis.port.output.ResponsibleAdultRepository;
import ar.net.sabadostech.sis.port.output.StudentRecordRepository;
import ar.net.sabadostech.sis.port.output.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class CreateStudentRecordServiceTest {

    private StudentRepository studentRepository;
    private ResponsibleAdultRepository adultRepository;
    private GradeRepository gradeRepository;
    private StudentRecordRepository studentRecordRepository;
    private CreateStudentRecordService service;

    @BeforeEach
    void setUp() {
        studentRepository = mock(StudentRepository.class);
        adultRepository = mock(ResponsibleAdultRepository.class);
        gradeRepository = mock(GradeRepository.class);
        studentRecordRepository = mock(StudentRecordRepository.class);
        service = new CreateStudentRecordService(studentRepository, adultRepository, gradeRepository, studentRecordRepository);
    }

    @Test
    void shouldCreateStudentRecordSuccessfully() {
        CreateStudentRecordRequest request = new CreateStudentRecordRequest();
        request.setStudentId("S1");
        request.setStudentFullName("John Doe");
        request.setDateOfBirth(LocalDate.of(2010, 5, 15));
        request.setGradeId("G1");

        GuardianDto guardian = new GuardianDto();
        guardian.setAdultId("RA1");
        guardian.setFullName("Jane Doe");
        guardian.setEmail("jane@example.com");
        guardian.setPhone("1234567890");
        guardian.setRole("MOTHER");
        guardian.setPrimaryContact(true);

        request.setGuardians(List.of(guardian));

        when(studentRecordRepository.existsByStudentId("S1")).thenReturn(false);
        when(gradeRepository.findById("G1")).thenReturn(Optional.of(new Grade()));
        when(adultRepository.existsById("RA1")).thenReturn(false);

        service.execute(request);

        verify(studentRecordRepository).save(any(StudentRecord.class));
    }
}
