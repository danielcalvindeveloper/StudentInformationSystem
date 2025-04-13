package ar.net.sabadostech.sis.adapter.out.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * JPA entity for ResponsibleAdult.
 */
@Data
@Entity
public class ResponsibleAdultEntity {
    @Id
    private String id;
    private String fullName;
    private String email;
    private String phone;
}
