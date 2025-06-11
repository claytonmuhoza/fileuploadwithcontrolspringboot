package com.claytonmuhoza.fileuploadwithspring.controller;


import com.claytonmuhoza.fileuploadwithspring.dto.DocumentDto;
import com.claytonmuhoza.fileuploadwithspring.dto.PersonDto;
import com.claytonmuhoza.fileuploadwithspring.model.Document;
import com.claytonmuhoza.fileuploadwithspring.service.DocumentService;
import com.claytonmuhoza.fileuploadwithspring.storage.StorageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.util.List;

@Validated
@RestController
@RequestMapping("api")
public class DocumentRestController {
    DocumentService documentService;
    StorageService storageService;
    public DocumentRestController(DocumentService  documentService, StorageService storageService) {
        this.documentService = documentService;
        this.storageService = storageService;
    }
    @GetMapping("/files")
    public List<Document> getDocuments() {
        return documentService.findAll();
    }
    @GetMapping("/file/{id}")
    public ResponseEntity<Resource> getDocument(@PathVariable Long id) {
        Document document = documentService.findById(id);
        String filename = document.getDocumentUrl();
        Resource file = storageService.loadAsResource(filename);

        if (file == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }




    @PostMapping(value = "file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveDocument(@Valid @ModelAttribute DocumentDto documentDto, BindingResult bindingResult) {

        Document document = documentService.save(documentDto);

        return ResponseEntity.ok(document);

    }
    @PostMapping(value = "/json/file")
    public ResponseEntity<Document> uploadDocument(@Valid @RequestBody PersonDto personDto, @RequestParam("file")MultipartFile pdfDto, BindingResult bindingResult) {

        DocumentDto documentDto = new DocumentDto();
        documentDto.setFirstname(personDto.getFirstname());
        documentDto.setLastname(personDto.getLastname());
        Document document = documentService.save(documentDto);

        return ResponseEntity.ok(document);
    }
}
