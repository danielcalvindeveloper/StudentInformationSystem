package ar.net.sabadostech.sis.adapter.out.persistence.mapper;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.ResponsibleAdultEntity;
import ar.net.sabadostech.sis.domain.model.ResponsibleAdult;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-13T00:22:12-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 23.0.1 (Eclipse Adoptium)"
)
@Component
public class ResponsibleAdultMapperImpl implements ResponsibleAdultMapper {

    @Override
    public ResponsibleAdultEntity toEntity(ResponsibleAdult model) {
        if ( model == null ) {
            return null;
        }

        ResponsibleAdultEntity responsibleAdultEntity = new ResponsibleAdultEntity();

        responsibleAdultEntity.setEmail( model.getEmail() );
        responsibleAdultEntity.setFullName( model.getFullName() );
        responsibleAdultEntity.setId( model.getId() );
        responsibleAdultEntity.setPhone( model.getPhone() );

        return responsibleAdultEntity;
    }

    @Override
    public ResponsibleAdult toDomain(ResponsibleAdultEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ResponsibleAdult responsibleAdult = new ResponsibleAdult();

        responsibleAdult.setEmail( entity.getEmail() );
        responsibleAdult.setFullName( entity.getFullName() );
        responsibleAdult.setId( entity.getId() );
        responsibleAdult.setPhone( entity.getPhone() );

        return responsibleAdult;
    }
}
