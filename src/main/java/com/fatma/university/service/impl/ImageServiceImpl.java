package com.fatma.university.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Service
@Slf4j
public class ImageServiceImpl  {

    public String saveImageToBase64(String imagePath) {
        try {
            Path filePath = Path.of(imagePath);
            byte[] imageData = Files.readAllBytes(filePath);
            return Base64.getEncoder().encodeToString(imageData);
        } catch (IOException e) {
            log.error("Error reading image file: {}", e.getMessage());
            return null;
        }
    }
}
