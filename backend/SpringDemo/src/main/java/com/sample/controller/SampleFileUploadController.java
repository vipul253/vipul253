package com.sample.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from Angular development server
public class SampleFileUploadController {
	
	private final Path rootLocation = Paths.get("uploads"); // Directory to save files

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            // Ensure the upload directory exists
            if (!Files.exists(rootLocation)) {
                Files.createDirectories(rootLocation);
            }
            // Save the file
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
            
            return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"Upload successful: " + file.getOriginalFilename() + "\"}");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("{\"message\": \"Upload failed for " + file.getOriginalFilename() + ".\"}");
        }
    }
}
