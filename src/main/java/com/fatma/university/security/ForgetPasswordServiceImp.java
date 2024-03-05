package com.fatma.university.security;

import com.fatma.university.model.entity.Source;
import com.fatma.university.model.entity.Student;
import com.fatma.university.repository.SourceRepo;
import com.fatma.university.repository.StudentRepo;
import com.fatma.university.security.dto.UpdatePasswordDto;
import com.fatma.university.service.utils.MailService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;


@Service
public class ForgetPasswordServiceImp implements ForgetPasswordService {

    private final SourceRepo sourceRepo;
    private final StudentRepo studentRepo;
    private final MailService mailService;

    public ForgetPasswordServiceImp(SourceRepo sourceRepo, StudentRepo studentRepo, MailService mailService) {
        this.sourceRepo = sourceRepo;
        this.studentRepo = studentRepo;
        this.mailService = mailService;
    }


    @Override
    public String sendOtp(String email) {
        // get user by email
        Optional<Student> student = studentRepo.findByEmail(email);

        if (student.isPresent()) {
            String studentOtp = updateStudentOtp(student.get());
            return sendOtpToEmail(email, studentOtp);
        }
        Optional<Source> source = sourceRepo.findByEmail(email);
        if (source.isPresent()) {
            String sourceOtp = updateSourceOtp(source.get());
            return sendOtpToEmail(email, sourceOtp);
        }
        throw new NoSuchElementException("This Email Are Not Found");
    }

    private String sendOtpToEmail(String email, String otp) {
        mailService.sendMessageToEmail(email, "Your Otp to Can Update Your Password is '" + otp + "'");
        return otp;
    }

    private String updateSourceOtp(Source source) {
        String otp = generateRandomOtp();
        source.setOtp(otp);
        sourceRepo.save(source);
        return otp;
    }

    private String updateStudentOtp(Student student) {
        String otp = generateRandomOtp();
        student.setOtp(otp);
        studentRepo.save(student);
        return otp;
    }

    @Override
    public String forgetPassword(UpdatePasswordDto updatePasswordDto) {
        if (!Objects.equals(updatePasswordDto.getPassword(), updatePasswordDto.getConfirmPassword()))
            throw new RuntimeException("Passwords Are Not The Same....");

        Optional<Student> student = studentRepo.findByEmail(updatePasswordDto.getEmail());
        if (student.isPresent()) {
            Student existingStudent = student.get();
            Objects.requireNonNull(existingStudent.getOtp(), "Otp Is Null");
            if (!updatePasswordDto.getOtp().equals(existingStudent.getOtp()))
                throw new RuntimeException("Otp Not Matched");
            existingStudent.setPassword(updatePasswordDto.getPassword());
            existingStudent.setOtp(null);
            studentRepo.save(existingStudent);
            return "Updated...";
        }
        Optional<Source> source = sourceRepo.findByEmail(updatePasswordDto.getEmail());
        if (source.isPresent()) {
            Source existingSource = source.get();
            Objects.requireNonNull(existingSource.getOtp(), "Otp Is Null");
            if (!updatePasswordDto.getOtp().equals(existingSource.getOtp()))
                throw new RuntimeException("Otp Not Matched");
            existingSource.setPassword(updatePasswordDto.getPassword());
            existingSource.setOtp(null);
            sourceRepo.save(existingSource);
            return "Updated...";
        }

        throw new NoSuchElementException("Email Not Found");
    }


    public String generateRandomOtp() {
        int min = 1000;
        int max = 9999;
        Random random = new Random();
        int otpValue = random.nextInt(max - min + 1) + min;
        return String.valueOf(otpValue);
    }
}
