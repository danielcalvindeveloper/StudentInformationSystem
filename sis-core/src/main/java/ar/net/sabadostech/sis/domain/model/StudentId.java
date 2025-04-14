package ar.net.sabadostech.sis.domain.model;

import java.util.Objects;

/**
 * Identificador único para estudiantes, con formato STU-0001, STU-0002, etc.
 * Parte de la identidad como valor de dominio.
 */
public class StudentId {

    private final String value;

    private StudentId(String value) {
        if (!value.matches("STU-\\d{4}")) {
            throw new IllegalArgumentException("Invalid StudentId format: " + value);
        }
        this.value = value;
    }

    /**
     * Crea una nueva instancia de StudentId a partir de una secuencia numérica.
     * @param sequence número correlativo
     * @return nuevo StudentId con formato STU-XXXX
     */
    public static StudentId generate(int sequence) {
        return new StudentId("STU-" + String.format("%04d", sequence));
    }

    /**
     * Crea una instancia desde un valor existente.
     */
    public static StudentId of(String raw) {
        return new StudentId(raw);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentId)) return false;
        StudentId that = (StudentId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}