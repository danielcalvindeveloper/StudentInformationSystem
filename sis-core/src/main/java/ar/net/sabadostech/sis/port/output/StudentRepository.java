package ar.net.sabadostech.sis.port.output;

import ar.net.sabadostech.sis.domain.model.Student;

import java.util.Optional;

/**
 * Output port for accessing and managing students.
 */
public interface StudentRepository {
    Optional<Student> findById(String studentId);
    boolean existsById(String studentId);
    void save(Student student);
}
