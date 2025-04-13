package ar.net.sabadostech.sis.adapter.out.persistence.mapper;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.ResponsibleAdultEntity;
import ar.net.sabadostech.sis.domain.model.ResponsibleAdult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponsibleAdultMapper {
    ResponsibleAdultEntity toEntity(ResponsibleAdult model);
    ResponsibleAdult toDomain(ResponsibleAdultEntity entity);
}
