package ar.net.sabadostech.sis.adapter.out.persistence.mapper;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.StudentEntity;
import ar.net.sabadostech.sis.domain.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentEntity toEntity(Student student);
    Student toDomain(StudentEntity entity);
}
