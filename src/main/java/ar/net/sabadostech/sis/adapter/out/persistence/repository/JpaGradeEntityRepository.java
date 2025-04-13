package ar.net.sabadostech.sis.adapter.out.persistence.repository;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGradeEntityRepository extends JpaRepository<GradeEntity, String> {
}
