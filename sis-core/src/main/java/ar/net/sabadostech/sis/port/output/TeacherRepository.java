package ar.net.sabadostech.sis.port.output;

import ar.net.sabadostech.sis.domain.model.Teacher;

import java.util.List;

/**
 * Output port for accessing teachers.
 */
public interface TeacherRepository {
    List<Teacher> findAll();
}
