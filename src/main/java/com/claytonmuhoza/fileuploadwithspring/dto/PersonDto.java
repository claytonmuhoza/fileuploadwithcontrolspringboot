package com.claytonmuhoza.fileuploadwithspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PersonDto {
    @NotBlank(message = "Firstname is required")
    @Size(min = 2, message = "Firstname field must have at least two character")
    private String firstname;
    @NotBlank(message = "Lastname is required")
    @Size(min = 2, message = "Lastname field must have at least two character")
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
