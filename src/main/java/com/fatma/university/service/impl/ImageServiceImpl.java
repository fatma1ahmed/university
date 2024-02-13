package com.fatma.university.service.impl;

import com.fatma.university.service.ImagesService;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImagesService {
    public byte[] decodeBase64(String base64Image)  {
        return Base64.getDecoder().decode(base64Image);
    }

    public String saveImage(byte[] imageBytes) throws IOException{
        String fileName= UUID.randomUUID().toString()+ ".png";
        String folderPath="src/main/resources/images/";
        try(FileOutputStream fos=new FileOutputStream(folderPath+fileName)){
            fos.write(imageBytes);
        }

        return folderPath+fileName ;
    }
}
