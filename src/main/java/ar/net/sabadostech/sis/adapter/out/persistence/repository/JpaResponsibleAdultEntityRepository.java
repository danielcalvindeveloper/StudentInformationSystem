package ar.net.sabadostech.sis.adapter.out.persistence.repository;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.ResponsibleAdultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaResponsibleAdultEntityRepository extends JpaRepository<ResponsibleAdultEntity, String> {
}
