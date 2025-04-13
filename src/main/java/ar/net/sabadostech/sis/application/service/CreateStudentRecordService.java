package ar.net.sabadostech.sis.application.service;

import ar.net.sabadostech.sis.domain.model.*;
import ar.net.sabadostech.sis.dto.CreateStudentRecordRequest;
import ar.net.sabadostech.sis.dto.GuardianDto;
import ar.net.sabadostech.sis.port.input.CreateStudentRecordUseCase;
import ar.net.sabadostech.sis.port.output.GradeRepository;
import ar.net.sabadostech.sis.port.output.ResponsibleAdultRepository;
import ar.net.sabadostech.sis.port.output.StudentRecordRepository;
import ar.net.sabadostech.sis.port.output.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Application service to handle creation of a new StudentRecord.
 */
@RequiredArgsConstructor
public class CreateStudentRecordService implements CreateStudentRecordUseCase {

    private static final Logger logger = LoggerFactory.getLogger(CreateStudentRecordService.class);

    private final StudentRepository studentRepository;
    private final ResponsibleAdultRepository adultRepository;
    private final GradeRepository gradeRepository;
    private final StudentRecordRepository studentRecordRepository;

    @Override
    public void execute(CreateStudentRecordRequest request) {
        logger.info("Creating student record for student ID: {}", request.getStudentId());

        if (studentRecordRepository.existsByStudentId(request.getStudentId())) {
            throw new IllegalStateException("Student already has a record.");
        }

        Student student = new Student();
        student.setId(request.getStudentId());
        student.setFullName(request.getStudentFullName());
        student.setDateOfBirth(request.getDateOfBirth());

        Grade grade = gradeRepository.findById(request.getGradeId())
                .orElseThrow(() -> new IllegalArgumentException("Grade not found: " + request.getGradeId()));

        List<GuardianAssignment> assignments = request.getGuardians().stream()
                .map(dto -> {
                    ResponsibleAdult adult = (dto.getAdultId() != null && adultRepository.existsById(dto.getAdultId()))
                            ? adultRepository.findById(dto.getAdultId()).orElseThrow()
                            : new ResponsibleAdult();

                    adult.setId(dto.getAdultId());
                    adult.setFullName(dto.getFullName());
                    adult.setPhone(dto.getPhone());
                    adult.setEmail(dto.getEmail());

                    GuardianAssignment assignment = new GuardianAssignment();
                    assignment.setStudent(student);
                    assignment.setAdult(adult);
                    assignment.setRole(GuardianRole.valueOf(dto.getRole()));
                    assignment.setPrimaryContact(dto.isPrimaryContact());
                    return assignment;
                }).collect(Collectors.toList());

        Predicate<String> existsStudentRecord = studentRecordRepository::existsByStudentId;

        StudentRecord record = StudentRecord.create(student, grade, assignments, existsStudentRecord);

        studentRecordRepository.save(record);
    }
}
