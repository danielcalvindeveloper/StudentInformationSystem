package ar.net.sabadostech.sis.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Representa a un adulto responsable.
 */
@AllArgsConstructor
@Getter
public class ResponsibleAdult implements NotificationRecipient {

    private final String fullName;
    private final String email;
    private final String phone;
    private final boolean preferred;
    private boolean receivesAdministrativeNotifications;


    @Override
    public String getName() {
        return fullName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getRole() {
        return "RESPONSIBLE_ADULT";
    }

    @Override
    public boolean isPrimary() {
        return preferred;
    }
    
    public boolean wantsAdministrativeNotifications() {
        return receivesAdministrativeNotifications;
    }

    public void enableAdministrativeNotifications() {
        this.receivesAdministrativeNotifications = true;
    }

    public void disableAdministrativeNotifications() {
        this.receivesAdministrativeNotifications = false;
    }
    
}