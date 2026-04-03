package com.federal.prision.amazon;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class S3Controller {

    private final S3Service s3Service;

    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping("/upload/{id}")
    public String upload(@RequestParam("file") MultipartFile file,
                         @PathVariable Long id) throws Exception {

        String key = UUID.randomUUID() + "-" + file.getOriginalFilename();

        String url = s3Service.uploadFile(
            key,
            file,
            id
        );

        return url; 
    }
    
    
}