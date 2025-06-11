package com.claytonmuhoza.fileuploadwithspring.repository;

import com.claytonmuhoza.fileuploadwithspring.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
