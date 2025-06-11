package com.claytonmuhoza.fileuploadwithspring.controller;

import com.claytonmuhoza.fileuploadwithspring.dto.ErrorResponseDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex) {
        List<String> errors = ex.getConstraintViolations().stream()
                .map(violation ->   violation.getMessage())
                .collect(Collectors.toList());
        ErrorResponseDto errorResponseDto =  new ErrorResponseDto();
        errorResponseDto.setErrors(errors);

        return ResponseEntity.badRequest().body(errorResponseDto);
    }
}