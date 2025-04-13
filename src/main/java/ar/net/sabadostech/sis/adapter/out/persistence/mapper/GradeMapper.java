package ar.net.sabadostech.sis.adapter.out.persistence.mapper;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.GradeEntity;
import ar.net.sabadostech.sis.domain.model.Grade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GradeMapper {
    GradeEntity toEntity(Grade model);
    Grade toDomain(GradeEntity entity);
}
