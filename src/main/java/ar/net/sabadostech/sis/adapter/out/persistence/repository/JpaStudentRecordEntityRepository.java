package ar.net.sabadostech.sis.adapter.out.persistence.repository;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.StudentRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStudentRecordEntityRepository extends JpaRepository<StudentRecordEntity, String> {
}
