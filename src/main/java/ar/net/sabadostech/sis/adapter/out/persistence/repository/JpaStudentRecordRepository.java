package ar.net.sabadostech.sis.adapter.out.persistence.repository;

import ar.net.sabadostech.sis.domain.model.StudentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * JPA repository for StudentRecord entity.
 */
public interface JpaStudentRecordRepository extends JpaRepository<StudentRecord, String> {
    Optional<StudentRecord> findByStudent_StudentId(String studentId);
    boolean existsByStudent_StudentId(String studentId);
}
