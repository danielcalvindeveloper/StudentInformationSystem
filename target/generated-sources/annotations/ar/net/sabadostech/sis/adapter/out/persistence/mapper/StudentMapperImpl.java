package ar.net.sabadostech.sis.adapter.out.persistence.mapper;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.StudentEntity;
import ar.net.sabadostech.sis.domain.model.Student;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-13T00:22:12-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 23.0.1 (Eclipse Adoptium)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentEntity toEntity(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setDateOfBirth( student.getDateOfBirth() );
        studentEntity.setFullName( student.getFullName() );
        studentEntity.setId( student.getId() );

        return studentEntity;
    }

    @Override
    public Student toDomain(StudentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Student student = new Student();

        student.setDateOfBirth( entity.getDateOfBirth() );
        student.setFullName( entity.getFullName() );
        student.setId( entity.getId() );

        return student;
    }
}
