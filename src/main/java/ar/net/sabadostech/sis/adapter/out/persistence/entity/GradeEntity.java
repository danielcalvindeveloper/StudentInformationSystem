package ar.net.sabadostech.sis.adapter.out.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * JPA entity for Grade.
 */
@Data
@Entity
public class GradeEntity {
    @Id
    private String id;
    private String name;
}
