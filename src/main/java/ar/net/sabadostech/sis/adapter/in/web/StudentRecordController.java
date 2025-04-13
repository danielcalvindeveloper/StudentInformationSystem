package ar.net.sabadostech.sis.adapter.in.web;

import ar.net.sabadostech.sis.dto.CreateStudentRecordRequest;
import ar.net.sabadostech.sis.port.input.CreateStudentRecordUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student-records")
@RequiredArgsConstructor
@Tag(name = "Student Records", description = "Manage student records")
public class StudentRecordController {

    private final CreateStudentRecordUseCase createStudentRecordUseCase;

    @Operation(summary = "Create a new student record")
    @PostMapping
    public ResponseEntity<Void> createStudentRecord(@Valid @RequestBody CreateStudentRecordRequest request) {
        createStudentRecordUseCase.execute(request);
        return ResponseEntity.ok().build();
    }
}
