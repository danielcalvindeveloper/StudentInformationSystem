package ar.net.sabadostech.sis.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a student enrolled in the institution.
 */
@Data
@AllArgsConstructor
@Getter
public class Student {
    private String id;
    private String fullName;
    private LocalDate dateOfBirth;
}
