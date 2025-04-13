package ar.net.sabadostech.sis.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

/**
 * Request to create a new StudentRecord.
 */
@Data
public class CreateStudentRecordRequest {

    @NotBlank(message = "Student ID is required")
    private String studentId;

    @NotBlank(message = "Full name is required")
    private String studentFullName;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Grade ID is required")
    private String gradeId;

    @NotEmpty(message = "At least one guardian is required")
    @Valid
    private List<GuardianDto> guardians;
}
