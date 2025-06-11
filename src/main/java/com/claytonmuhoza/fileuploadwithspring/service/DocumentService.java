package com.claytonmuhoza.fileuploadwithspring.service;


import com.claytonmuhoza.fileuploadwithspring.model.Document;
import com.claytonmuhoza.fileuploadwithspring.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    private DocumentRepository documentRepository;
    public DocumentService(DocumentRepository documentRepository){
        this.documentRepository = documentRepository;
    }
    public List<Document> findAll() {
        return documentRepository.findAll();
    }
    public Document findById(Long id) {
        return documentRepository.findById(id).get();
    }
    public void save(Document document) {
        documentRepository.save(document);
    }
}
