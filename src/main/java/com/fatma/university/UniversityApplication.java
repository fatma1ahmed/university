package com.fatma.university;

import com.fatma.university.model.entity.College;
import com.fatma.university.reposity.CollegeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

@SpringBootApplication
@Slf4j
public class UniversityApplication  implements CommandLineRunner {

    @Autowired
    private CollegeRepo collegeRepo;

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
        log.info("Running Successfully By Moaaz And Fatma...");
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

    @Override
    public void run(String... args) throws Exception {
        collegeRepo.deleteAll();
        ArrayList<College> colleges = new ArrayList<>(Arrays.asList(
                College.builder().id(1L)
                        .icon(convertToBase64("/college_icons/adab 1.png"))
                        .name("أداب")
                        .build(),
                College.builder().id(2L)
                        .icon(convertToBase64("/college_icons/ektesad 1.png"))
                        .name("اقتصاد")
                        .build(),
                College.builder().id(3L)
                        .icon(convertToBase64("/college_icons/fanaya 1.png"))
                        .name("تربيه فنيه")
                        .build(),
                College.builder().id(4L)
                        .icon(convertToBase64("/college_icons/gamela 1.png"))
                        .name("فنون جميله")
                        .build(),
                College.builder().id(5L)
                        .icon(convertToBase64("/college_icons/handasa_helwan 1.png"))
                        .name("الهندسه(حلوان)")
                        .build(),
                College.builder().id(6L)
                        .icon(convertToBase64("/college_icons/handasa_mataraya 1.png"))
                        .name("الهندسه(مطريه)")
                        .build(),
                College.builder().id(7L)
                        .icon(convertToBase64("/college_icons/hasebat 1.png"))
                        .name("حاسبات ومعلومات")
                        .build(),
                College.builder().id(8L)
                        .icon(convertToBase64("/college_icons/hokok 1.png"))
                        .name("حقوق")
                        .build(),
                College.builder().id(9L)
                        .icon(convertToBase64("/college_icons/khadma 1.png"))
                        .name("خدمه اجتماعيه")
                        .build(),
                College.builder().id(10L)
                        .icon(convertToBase64("/college_icons/music 1.png"))
                        .name("تربيه موسيقيه")
                        .build(),
                College.builder().id(11L)
                        .icon(convertToBase64("/college_icons/olom 1.png"))
                        .name("العلوم")
                        .build(),
                College.builder().id(12L)
                        .icon(convertToBase64("/college_icons/ryadaya_banat 1.png"))
                        .name("تربيه رياضه بنات")
                        .build(),
                College.builder().id(13L)
                        .icon(convertToBase64("/college_icons/ryadaya_baneen 1.png"))
                        .name("تربيه رياضه بنات")
                        .build(),
                College.builder().id(14L)
                        .icon(convertToBase64("/college_icons/saydala 1.png"))
                        .name("صيدله")
                        .build(),
                College.builder().id(15L)
                        .icon(convertToBase64("/college_icons/tab 1.png"))
                        .name("طب")
                        .build(),
                College.builder().id(16L)
                        .icon(convertToBase64("/college_icons/tamreed 1.png"))
                        .name("تمريض")
                        .build(),
                College.builder().id(17L)
                        .icon(convertToBase64("/college_icons/tarbaya 1.png"))
                        .name("تربيه")
                        .build(),
                College.builder().id(18L)
                        .icon(convertToBase64("/college_icons/tegara 1.png"))
                        .name("تجاره")
                        .build()
        ));
        collegeRepo.saveAll(colleges);

    }
}
