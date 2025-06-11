package com.claytonmuhoza.fileuploadwithspring.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class PDFFileValidator implements ConstraintValidator<ValidPDF, MultipartFile> {

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file == null || file.isEmpty()) return false;

        String contentType = file.getContentType();
        return "application/pdf".equalsIgnoreCase(contentType);
    }
}
