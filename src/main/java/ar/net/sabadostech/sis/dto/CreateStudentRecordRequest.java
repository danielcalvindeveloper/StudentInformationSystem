package ar.net.sabadostech.sis.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

/**
 * Request to create a new StudentRecord.
 */
@Data
public class CreateStudentRecordRequest {
    private String studentId;
    private String studentFullName;
    private LocalDate dateOfBirth;
    private String gradeId;
    private List<GuardianDto> guardians;
}
