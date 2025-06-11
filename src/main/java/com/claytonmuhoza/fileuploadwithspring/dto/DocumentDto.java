package com.claytonmuhoza.fileuploadwithspring.dto;

import com.claytonmuhoza.fileuploadwithspring.validator.ValidPDF;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class DocumentDto {

    @NotBlank(message = "Firstname is required")
    @Size(min = 2, message = "Firstname field must have at least two character")
    private String firstname;
    @NotBlank(message = "Lastname is required")
    @Size(min = 2, message = "Lastname field must have at least two character")
    private String lastname;
    @ValidPDF(message = "Le fichier doit être un PDF")
    private MultipartFile file;

    // Getters & setters
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public MultipartFile getFile() { return file; }
    public void setFile(MultipartFile file) { this.file = file; }
}
