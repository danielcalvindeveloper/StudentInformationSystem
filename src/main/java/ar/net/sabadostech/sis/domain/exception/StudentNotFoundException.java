package ar.net.sabadostech.sis.domain.exception;

/**
 * Exception thrown when a student is not found in the system.
 */
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String studentId) {
        super("Student not found: " + studentId);
    }
}
