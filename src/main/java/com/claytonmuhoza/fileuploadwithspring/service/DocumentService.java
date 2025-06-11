package com.claytonmuhoza.fileuploadwithspring.service;


import com.claytonmuhoza.fileuploadwithspring.dto.DocumentDto;
import com.claytonmuhoza.fileuploadwithspring.model.Document;
import com.claytonmuhoza.fileuploadwithspring.repository.DocumentRepository;
import com.claytonmuhoza.fileuploadwithspring.storage.StorageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DocumentService {
    private DocumentRepository documentRepository;
    private StorageService storageService;
    public DocumentService(DocumentRepository documentRepository, StorageService storageService) {
        this.documentRepository = documentRepository;
        this.storageService = storageService;
    }
    public List<Document> findAll() {
        return documentRepository.findAll();
    }
    public Document findById(Long id) {
        return documentRepository.findById(id).get();
    }
    public Document save(DocumentDto documentDto) {
        Document document = new Document();
        document.setFirstname(documentDto.getFirstname());
        document.setLastname(documentDto.getLastname());
        String documentName = "document"+UUID.randomUUID()+".PDF";
        document.setDocumentUrl(documentName);
        storageService.store(documentDto.getFile(), documentName);

       return documentRepository.save(document);
    }
}
