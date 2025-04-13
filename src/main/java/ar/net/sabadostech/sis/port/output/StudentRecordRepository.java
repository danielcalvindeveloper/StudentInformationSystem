package ar.net.sabadostech.sis.port.output;

import ar.net.sabadostech.sis.domain.model.StudentRecord;

import java.util.Optional;

/**
 * Output port for accessing student records.
 */
public interface StudentRecordRepository {
    Optional<StudentRecord> findByStudentId(String studentId);
    boolean existsByStudentId(String studentId);
    void save(StudentRecord record);
}
