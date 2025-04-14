package ar.net.sabadostech.sis.port.input;

import ar.net.sabadostech.sis.dto.CreateStudentRecordRequest;

/**
 * Input port to create a new student record.
 */
public interface CreateStudentRecordUseCase {
    void execute(CreateStudentRecordRequest request);
}
