package com.fatma.university.security;

import com.fatma.university.model.Enum.UserRole;
import com.fatma.university.model.entity.Source;
import com.fatma.university.model.entity.Student;
import com.fatma.university.repository.SourceRepo;
import com.fatma.university.repository.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

            return CustomUserDetails.builder().id(1L).email(adminEmail).password(adminPassword).userRole(UserRole.ADMIN).build();
        }
        if (isDeveloper(username)) {

            return CustomUserDetails.builder()
                    .id(1L)
                    .email(developerEmail).password(developerPassword).userRole(UserRole.DEVELOPER).build();
        }
        Optional<Student> student = studentRepo.findByEmail(username);
        if (student.isPresent()) {
            Student existingStudent = student.get();
            return CustomUserDetails.builder().id(existingStudent.getId()).email(existingStudent.getEmail()).password(existingStudent.getPassword()).userRole(UserRole.STUDENT).build();
        }
        Optional<Source> source = sourceRepo.findByEmail(username);
        if (source.isPresent()) {
            Source existingSource = source.get();
            return CustomUserDetails.builder().id(existingSource.getId()).email(existingSource.getEmail()).password(existingSource.getPassword()).userRole(UserRole.SOURCE).build();
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
