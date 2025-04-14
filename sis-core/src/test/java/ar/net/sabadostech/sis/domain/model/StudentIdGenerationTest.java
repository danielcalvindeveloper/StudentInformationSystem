package ar.net.sabadostech.sis.domain.model;

import ar.net.sabadostech.sis.domain.service.IdSequenceService;
import ar.net.sabadostech.sis.infrastructure.sequence.InMemoryIdSequenceService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentIdGenerationTest {

    @Test
    public void testStudentIdGenerationSequential() {
        IdSequenceService sequenceService = new InMemoryIdSequenceService();

        StudentId id1 = StudentId.generate(sequenceService.next("STU"));
        StudentId id2 = StudentId.generate(sequenceService.next("STU"));

        assertEquals("STU-0001", id1.getValue());
        assertEquals("STU-0002", id2.getValue());
    }

    @Test
    public void testInvalidStudentIdFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StudentId.of("INVALID-01");
        });

        assertTrue(exception.getMessage().contains("Invalid StudentId format"));
    }
}