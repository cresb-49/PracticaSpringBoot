package com.carlos.springpage.dto;


import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangePasswordForm {

    @NotNull
    private Long id;

    @NotBlank(message = "La contrasena no debe estar en blanco")
    private String currentPassword;

    @NotBlank(message = "La nueva contrasena no debe estar en blanco")
    private String newPassword;

    @NotBlank(message = "La confirmacion de contrasena no debe estar en blanco")
    private String confirmPassword;

    public ChangePasswordForm() {

    }

    public ChangePasswordForm(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.currentPassword);
        hash = 67 * hash + Objects.hashCode(this.newPassword);
        hash = 67 * hash + Objects.hashCode(this.confirmPassword);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChangePasswordForm other = (ChangePasswordForm) obj;
        if (!Objects.equals(this.currentPassword, other.currentPassword)) {
            return false;
        }
        if (!Objects.equals(this.newPassword, other.newPassword)) {
            return false;
        }
        if (!Objects.equals(this.confirmPassword, other.confirmPassword)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ChangePasswordForm{" + "id=" + id + ", currentPassword=" + currentPassword + ", newPassword=" + newPassword + ", confirmPassword=" + confirmPassword + '}';
    }
}
