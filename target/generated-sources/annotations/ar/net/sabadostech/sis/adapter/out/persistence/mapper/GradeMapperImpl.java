package ar.net.sabadostech.sis.adapter.out.persistence.mapper;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.GradeEntity;
import ar.net.sabadostech.sis.domain.model.Grade;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-13T00:22:12-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 23.0.1 (Eclipse Adoptium)"
)
@Component
public class GradeMapperImpl implements GradeMapper {

    @Override
    public GradeEntity toEntity(Grade model) {
        if ( model == null ) {
            return null;
        }

        GradeEntity gradeEntity = new GradeEntity();

        gradeEntity.setId( model.getId() );
        gradeEntity.setName( model.getName() );

        return gradeEntity;
    }

    @Override
    public Grade toDomain(GradeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Grade grade = new Grade();

        grade.setId( entity.getId() );
        grade.setName( entity.getName() );

        return grade;
    }
}
