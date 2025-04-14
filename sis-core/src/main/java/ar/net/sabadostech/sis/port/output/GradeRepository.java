package ar.net.sabadostech.sis.port.output;

import ar.net.sabadostech.sis.domain.model.Grade;

import java.util.Optional;

/**
 * Output port for accessing grades.
 */
public interface GradeRepository {
    Optional<Grade> findById(String gradeId);
}
