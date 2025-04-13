package ar.net.sabadostech.sis.adapter.out.persistence.mapper;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.StudentRecordEntity;
import ar.net.sabadostech.sis.domain.model.StudentRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        StudentMapper.class,
        GradeMapper.class,
        GuardianAssignmentMapper.class
})
public interface StudentRecordMapper {
    StudentRecordEntity toEntity(StudentRecord model);
    StudentRecord toDomain(StudentRecordEntity entity);
}
