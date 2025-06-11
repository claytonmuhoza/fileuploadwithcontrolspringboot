package com.claytonmuhoza.fileuploadwithspring.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PDFFileValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPDF {
    String message() default "Le fichier doit être un PDF et ne doit pas et";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}