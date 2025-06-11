package com.claytonmuhoza.fileuploadwithspring.controller;


import com.claytonmuhoza.fileuploadwithspring.dto.DocumentDto;
import com.claytonmuhoza.fileuploadwithspring.model.Document;
import com.claytonmuhoza.fileuploadwithspring.service.DocumentService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveDocument(@Valid @ModelAttribute DocumentDto documentDto, BindingResult bindingResult) {
        try {
            Document document = new Document();
            document.setFirstname(documentDto.getFirstname());
            document.setLastname(documentDto.getLastname());
            UUID uuid = UUID.randomUUID();
            document.setDocumentUrl("document"+uuid+".PDF");
            documentService.save(document);

            return ResponseEntity.ok(document);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }
}
