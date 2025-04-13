package ar.net.sabadostech.sis.domain.model;

import lombok.Data;
import java.time.LocalDate;

/**
 * Represents a student enrolled in the institution.
 */
@Data
public class Student {
    private String id;
    private String fullName;
    private LocalDate dateOfBirth;
}
