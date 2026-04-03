package com.federal.prision.amazon;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.federal.prision.person.Person;
import com.federal.prision.person.PersonRepository;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class S3Service {

	
	@Autowired
	PersonRepository personRepository;
	
    @Autowired
    private S3Client s3Client;

    @Value("${aws.bucket.name}")
    private String bucketName;
    public String uploadFile(String key, MultipartFile file, Long id) throws IOException {

    	PutObjectRequest request = PutObjectRequest.builder()
    	        .bucket(bucketName)
    	        .key(key)
    	        .contentType(file.getContentType()) // 👈 automático
    	        .build();

        s3Client.putObject(request, RequestBody.fromBytes(file.getBytes()));

        String url = "https://" + bucketName + ".s3.us-east-2.amazonaws.com/" + key;

        Person person = personRepository.findById(id)
                .orElseThrow();

        person.setImageUrl(url);

        personRepository.save(person);

        return url;
        
    }
}