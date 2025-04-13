package ar.net.sabadostech.sis.adapter.out.persistence.repository;

import ar.net.sabadostech.sis.domain.model.ResponsibleAdult;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for ResponsibleAdult entity.
 */
public interface JpaResponsibleAdultRepository extends JpaRepository<ResponsibleAdult, String> {
}
