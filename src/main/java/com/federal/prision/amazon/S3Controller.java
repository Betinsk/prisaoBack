package com.federal.prision.amazon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class S3Controller {

	
	@Autowired
	S3Service s3Service;
	
	@PostMapping("/files/upload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {

	    try {
	        String key = file.getOriginalFilename();
	        s3Service.uploadFile(key, file.getBytes());

	        return ResponseEntity.ok("Upload feito: " + key);
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().body("Erro no upload");
	    }
	}
	
}
