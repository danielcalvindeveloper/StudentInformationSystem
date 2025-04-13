package ar.net.sabadostech.sis.adapter.out.persistence.mapper;

import ar.net.sabadostech.sis.adapter.out.persistence.entity.GuardianAssignmentEntity;
import ar.net.sabadostech.sis.adapter.out.persistence.entity.StudentRecordEntity;
import ar.net.sabadostech.sis.domain.model.GuardianAssignment;
import ar.net.sabadostech.sis.domain.model.StudentRecord;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-13T00:22:11-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 23.0.1 (Eclipse Adoptium)"
)
@Component
public class StudentRecordMapperImpl implements StudentRecordMapper {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private GuardianAssignmentMapper guardianAssignmentMapper;

    @Override
    public StudentRecordEntity toEntity(StudentRecord model) {
        if ( model == null ) {
            return null;
        }

        StudentRecordEntity studentRecordEntity = new StudentRecordEntity();

        studentRecordEntity.setAssignments( guardianAssignmentListToGuardianAssignmentEntityList( model.getAssignments() ) );
        studentRecordEntity.setCurrentGrade( gradeMapper.toEntity( model.getCurrentGrade() ) );
        studentRecordEntity.setStudent( studentMapper.toEntity( model.getStudent() ) );

        return studentRecordEntity;
    }

    @Override
    public StudentRecord toDomain(StudentRecordEntity entity) {
        if ( entity == null ) {
            return null;
        }

        StudentRecord studentRecord = new StudentRecord();

        studentRecord.setAssignments( guardianAssignmentEntityListToGuardianAssignmentList( entity.getAssignments() ) );
        studentRecord.setCurrentGrade( gradeMapper.toDomain( entity.getCurrentGrade() ) );
        studentRecord.setStudent( studentMapper.toDomain( entity.getStudent() ) );

        return studentRecord;
    }

    protected List<GuardianAssignmentEntity> guardianAssignmentListToGuardianAssignmentEntityList(List<GuardianAssignment> list) {
        if ( list == null ) {
            return null;
        }

        List<GuardianAssignmentEntity> list1 = new ArrayList<GuardianAssignmentEntity>( list.size() );
        for ( GuardianAssignment guardianAssignment : list ) {
            list1.add( guardianAssignmentMapper.toEntity( guardianAssignment ) );
        }

        return list1;
    }

    protected List<GuardianAssignment> guardianAssignmentEntityListToGuardianAssignmentList(List<GuardianAssignmentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<GuardianAssignment> list1 = new ArrayList<GuardianAssignment>( list.size() );
        for ( GuardianAssignmentEntity guardianAssignmentEntity : list ) {
            list1.add( guardianAssignmentMapper.toDomain( guardianAssignmentEntity ) );
        }

        return list1;
    }
}
