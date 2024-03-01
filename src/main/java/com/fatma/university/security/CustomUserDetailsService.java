package com.fatma.university.security;

import com.fatma.university.model.Enum.UserRole;
import com.fatma.university.model.entity.Source;
import com.fatma.university.model.entity.Student;
import com.fatma.university.reposity.SourceRepo;
import com.fatma.university.reposity.StudentRepo;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;
    @Value("${developer.email}")
    private String developerEmail;

    @Value("${developer.password}")
    private String developerPassword;

    private final PasswordEncoder passwordEncoder;
    private final StudentRepo studentRepo;
    private final SourceRepo sourceRepo;

    public CustomUserDetailsService(PasswordEncoder passwordEncoder, StudentRepo studentRepo, SourceRepo sourceRepo) {
        this.passwordEncoder = passwordEncoder;

        this.studentRepo = studentRepo;
        this.sourceRepo = sourceRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (isAdmin(username)) {

            return CustomUserDetails.builder().email(adminEmail).password(adminPassword).userRole(UserRole.ADMIN).build();
        }
        if (isDeveloper(username)) {

            CustomUserDetails customUserDetails = CustomUserDetails.builder()
                    .email(developerEmail).password(developerPassword).userRole(UserRole.DEVELOPER).build();
            log.info("Developer {}", customUserDetails.toString());
            System.out.println(customUserDetails.isCredentialsNonExpired());
            return customUserDetails;
        }
        Optional<Student> student = studentRepo.findByEmail(username);
        if (student.isPresent()) {
            Student existingStudent = student.get();

            return CustomUserDetails.builder().email(existingStudent.getEmail()).password(existingStudent.getEmail()).userRole(UserRole.STUDENT).build();
        }
        Optional<Source> source = sourceRepo.findByEmail(username);
        if (source.isPresent()) {
            Source existingSource = source.get();
            System.out.println(existingSource.getEmail());
            return CustomUserDetails.builder().email(existingSource.getEmail()).password(existingSource.getEmail()).userRole(UserRole.SOURCE).build();
        }

        throw new UsernameNotFoundException("Email Are Not Exist");

    }

    private boolean isDeveloper(String username) {
        return username.equals(developerEmail);
    }

    private boolean isAdmin(String email) {
        return email.equals(adminEmail);

    }
}
