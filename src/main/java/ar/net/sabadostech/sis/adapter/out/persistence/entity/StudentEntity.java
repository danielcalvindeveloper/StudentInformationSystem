package ar.net.sabadostech.sis.adapter.out.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * JPA entity for Student.
 */
@Data
@Entity
public class StudentEntity {
    @Id
    private String id;
    private String fullName;
    private java.time.LocalDate dateOfBirth;
}
