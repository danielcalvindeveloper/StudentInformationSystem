package ar.net.sabadostech.sis.domain.model;

import ar.net.sabadostech.sis.domain.service.IdSequenceService;
import ar.net.sabadostech.sis.infrastructure.sequence.InMemoryIdSequenceService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherIdGenerationTest {

    @Test
    public void testTeacherCreationWithId() {
        IdSequenceService sequenceService = new InMemoryIdSequenceService();
        TeacherId teacherId = TeacherId.generate(sequenceService.next("TCH"));

        Teacher teacher = new Teacher(teacherId, "Ana Torres", "ana@colegio.com", "Matemática");

        assertEquals("Ana Torres", teacher.getName());
        assertEquals("ana@colegio.com", teacher.getEmail());
        assertEquals("TEACHER_MATEMÁTICA", teacher.getRole());
        assertEquals(teacherId.getValue(), teacher.getId().getValue());
    }
}