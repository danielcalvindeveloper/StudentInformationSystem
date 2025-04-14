package ar.net.sabadostech.sis.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * Represents a course or grade level in the school.
 */
@Data
@AllArgsConstructor
@Getter
public class Grade {
    private String id;
    private String name;
    private List<Subject> subjects;
}
