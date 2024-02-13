package com.fatma.university.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;

@Service
public interface ImagesService {
    public byte[] decodeBase64(String base64Image);

    public String saveImage(byte[] imageBytes) throws IOException;
}
