package com.claytonmuhoza.fileuploadwithspring.dto;

import org.springframework.web.multipart.MultipartFile;

public class PDFDto {
    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
