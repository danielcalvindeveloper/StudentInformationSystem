package ar.net.sabadostech.sis.domain.policy.context;

import ar.net.sabadostech.sis.domain.model.StudentRecord;
import ar.net.sabadostech.sis.domain.model.Grade;
import ar.net.sabadostech.sis.domain.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Contiene el contexto necesario para evaluar una política de notificación.
 * 
 * Este contexto encapsula información como el estudiante involucrado, su registro,
 * el grado o curso afectado, y cualquier otro actor relevante como docentes.
 * 
 * Cada política usará la parte del contexto que le sea relevante.
 */
@AllArgsConstructor
@Getter
public class NotificationContext {

    private StudentRecord studentRecord;

    private Grade grade;

    private Teacher teacher;

    private List<StudentRecord> allStudentsInGrade;

    private List<Teacher> allTeachers;

    // Otros datos adicionales según sea necesario
}