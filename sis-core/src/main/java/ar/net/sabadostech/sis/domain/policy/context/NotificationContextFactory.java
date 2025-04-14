package ar.net.sabadostech.sis.domain.policy.context;

import ar.net.sabadostech.sis.domain.model.Grade;
import ar.net.sabadostech.sis.domain.model.StudentRecord;
import ar.net.sabadostech.sis.domain.model.Teacher;

import java.util.List;

/**
 * Fábrica para construir instancias de {@link NotificationContext} de forma fluida y clara.
 * 
 * Útil para tests, casos de uso o reglas donde se conoce parcialmente la información relevante.
 */
public class NotificationContextFactory {

    public static NotificationContext forStudent(StudentRecord studentRecord) {
        return new NotificationContext(studentRecord, null, null, null, null);
    }

    public static NotificationContext forGrade(Grade grade, List<StudentRecord> students) {
        return new NotificationContext(null, grade, null, students, null);
    }

    public static NotificationContext forTeacherAndStudents(Teacher teacher, List<StudentRecord> students) {
        return new NotificationContext(null, null, teacher, students, null);
    }

    public static NotificationContext forAllSystemWide(List<StudentRecord> students, List<Teacher> teachers) {
        return new NotificationContext(null, null, null, students, teachers);
    }

    public static NotificationContext empty() {
        return new NotificationContext(null, null, null, null, null);
    }
}