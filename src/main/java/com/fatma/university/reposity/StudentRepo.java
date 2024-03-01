package com.fatma.university.reposity;

import com.fatma.university.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    Optional<Student> findByEmail(String username);
}
