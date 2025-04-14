package ar.net.sabadostech.sis.port.output;

import ar.net.sabadostech.sis.domain.model.ResponsibleAdult;

import java.util.Optional;
import java.util.List;

/**
 * Output port for accessing responsible adults.
 */
public interface ResponsibleAdultRepository {
    Optional<ResponsibleAdult> findById(String adultId);
    boolean existsById(String adultId);
    void save(ResponsibleAdult adult);
    List<ResponsibleAdult> findAll();
}
