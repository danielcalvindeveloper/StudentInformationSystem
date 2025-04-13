package ar.net.sabadostech.sis.domain.model;

import lombok.Data;
import java.util.List;

/**
 * Represents a course or grade level in the school.
 */
@Data
public class Grade {
    private String id;
    private String name;
    private List<Subject> subjects;
}
