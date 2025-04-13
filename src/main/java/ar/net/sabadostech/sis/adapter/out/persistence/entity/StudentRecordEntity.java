package ar.net.sabadostech.sis.adapter.out.persistence.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * JPA entity for StudentRecord.
 */
@Data
@Entity
public class StudentRecordEntity {

    @Id
    private String id;

    @OneToOne
    private StudentEntity student;

    @ManyToOne
    private GradeEntity currentGrade;

    @OneToMany(mappedBy = "studentRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GuardianAssignmentEntity> assignments;
}
