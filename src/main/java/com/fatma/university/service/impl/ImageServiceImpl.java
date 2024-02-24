package com.fatma.university.service.impl;

import com.fatma.university.service.ImagesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;
@Slf4j

@Service
public class ImageServiceImpl implements ImagesService {
    public byte[] decodeBase64(String base64Image)  {
        return Base64.getDecoder().decode(base64Image);
    }
    public String convertToBase64(String imagePath) {
        try {
            Resource resource = new ClassPathResource(imagePath);
            byte[] imageData = StreamUtils.copyToByteArray(resource.getInputStream());
            return Base64.getEncoder().encodeToString(imageData);
        } catch (IOException e) {
            log.error("Error reading image file: {}", e.getMessage());
            return null;
        }
    }

    public String saveImage(String imagePath) throws IOException{
        String fileName= UUID.randomUUID().toString()+ ".png";
        String folderPath="src/main/resources/student_images/";
        try(FileOutputStream fos=new FileOutputStream(folderPath+fileName)){
            fos.write(imagePath);
        }

        return folderPath+fileName ;
    }
}
