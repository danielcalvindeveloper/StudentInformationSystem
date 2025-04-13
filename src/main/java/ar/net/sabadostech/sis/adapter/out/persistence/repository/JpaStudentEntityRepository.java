package ar.net.sabadostech.sis.adapter.out.persistence.repository;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStudentEntityRepository extends JpaRepository<StudentEntity, String> {
}
