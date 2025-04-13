package ar.net.sabadostech.sis.adapter.out.persistence.mapper;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.GuardianAssignmentEntity;
import ar.net.sabadostech.sis.domain.model.GuardianAssignment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-13T00:22:11-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 23.0.1 (Eclipse Adoptium)"
)
@Component
public class GuardianAssignmentMapperImpl implements GuardianAssignmentMapper {

    @Override
    public GuardianAssignmentEntity toEntity(GuardianAssignment model) {
        if ( model == null ) {
            return null;
        }

        GuardianAssignmentEntity guardianAssignmentEntity = new GuardianAssignmentEntity();

        guardianAssignmentEntity.setPrimaryContact( model.isPrimaryContact() );
        guardianAssignmentEntity.setRole( model.getRole() );

        return guardianAssignmentEntity;
    }

    @Override
    public GuardianAssignment toDomain(GuardianAssignmentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        GuardianAssignment guardianAssignment = new GuardianAssignment();

        guardianAssignment.setPrimaryContact( entity.isPrimaryContact() );
        guardianAssignment.setRole( entity.getRole() );

        return guardianAssignment;
    }
}
