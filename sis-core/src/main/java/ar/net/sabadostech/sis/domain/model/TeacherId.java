package ar.net.sabadostech.sis.domain.model;

import java.util.Objects;

/**
 * Identificador único para docentes, con formato TCH-0001, TCH-0002, etc.
 * Parte de la identidad como valor de dominio.
 */
public class TeacherId {

    private final String value;

    private TeacherId(String value) {
        if (!value.matches("TCH-\\d{4}")) {
            throw new IllegalArgumentException("Invalid TeacherId format: " + value);
        }
        this.value = value;
    }

    /**
     * Crea una nueva instancia de TeacherId a partir de una secuencia numérica.
     * @param sequence número correlativo
     * @return nuevo TeacherId con formato TCH-XXXX
     */
    public static TeacherId generate(int sequence) {
        return new TeacherId("TCH-" + String.format("%04d", sequence));
    }

    /**
     * Crea una instancia desde un valor existente.
     */
    public static TeacherId of(String raw) {
        return new TeacherId(raw);
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
        if (!(o instanceof TeacherId)) return false;
        TeacherId that = (TeacherId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}