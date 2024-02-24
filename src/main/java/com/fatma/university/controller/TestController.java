package com.fatma.university.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {


    @PostMapping
    public String uploadFile(@ModelAttribute MultipartFile multipartFile) throws IOException {
        System.out.println("Resourcesssssssss... " + multipartFile.getResource());
        System.out.println("Content Type... " + multipartFile.getContentType());
        System.out.println("Original File Name...  " + multipartFile.getOriginalFilename());
        System.out.println("Name...  " + multipartFile.getName());
        System.out.println("Size " + multipartFile.getSize());
        System.out.println("Bytes... " + multipartFile.getBytes().toString());
//        System.out.println("Name...  " + multipartFile.getName());
        return "Done.";
    }
}
