package ar.net.sabadostech.sis.adapter.out.persistence.repository;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.GuardianAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGuardianAssignmentEntityRepository extends JpaRepository<GuardianAssignmentEntity, Long> {
}
