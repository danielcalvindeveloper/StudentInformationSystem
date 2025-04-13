package ar.net.sabadostech.sis.adapter.out.persistence.mapper;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.GuardianAssignmentEntity;
import ar.net.sabadostech.sis.domain.model.GuardianAssignment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuardianAssignmentMapper {
    GuardianAssignmentEntity toEntity(GuardianAssignment model);
    GuardianAssignment toDomain(GuardianAssignmentEntity entity);
}
