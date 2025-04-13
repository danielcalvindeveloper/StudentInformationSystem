package ar.net.sabadostech.sis.dto;

import lombok.Data;

/**
 * Represents a guardian in the request payload.
 */
@Data
public class GuardianDto {
    private String adultId;
    private String fullName;
    private String phone;
    private String email;
    private String role;
    private boolean primaryContact;
}
