package ar.net.sabadostech.sis.adapter.out.persistence.entity;

import javax.persistence.*;
import lombok.Data;

/**
 * JPA entity for GuardianAssignment.
 */
@Data
@Entity
public class GuardianAssignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentRecordEntity studentRecord;

    @ManyToOne
    private ResponsibleAdultEntity responsibleAdult;

    @Enumerated(EnumType.STRING)
    private ar.net.sabadostech.sis.domain.model.GuardianRole role;

    private boolean primaryContact;
}
