package com.claytonmuhoza.fileuploadwithspring.controller;


import com.claytonmuhoza.fileuploadwithspring.dto.DocumentDto;
import com.claytonmuhoza.fileuploadwithspring.dto.PDFDto;
import com.claytonmuhoza.fileuploadwithspring.dto.PersonDto;
import com.claytonmuhoza.fileuploadwithspring.model.Document;
import com.claytonmuhoza.fileuploadwithspring.service.DocumentService;
import com.claytonmuhoza.fileuploadwithspring.validator.ValidPDF;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("api")
public class DocumentRestController {
    DocumentService documentService;
    public DocumentRestController(DocumentService  DocumentService) {
        documentService = DocumentService;
    }
    @GetMapping("/files")
    public List<Document> getDocuments() {
        return documentService.findAll();
    }

    @PostMapping(value = "/json/file")
    public ResponseEntity<Document> uploadDocument(@Valid @RequestBody PersonDto personDto, @RequestParam("file")MultipartFile pdfDto, BindingResult bindingResult) {

        DocumentDto documentDto = new DocumentDto();
        documentDto.setFirstname(personDto.getFirstname());
        documentDto.setLastname(personDto.getLastname());
        Document document = documentService.save(documentDto);

        return ResponseEntity.ok(document);
    }

    @PostMapping(value = "file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveDocument(@Valid @ModelAttribute DocumentDto documentDto, BindingResult bindingResult) {

        Document document = documentService.save(documentDto);

        return ResponseEntity.ok(document);

    }
}
