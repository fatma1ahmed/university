package com.fatma.university.repository;

import com.fatma.university.model.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SourceRepo extends JpaRepository<Source,Long> {
    Optional<Source> findByEmail(String username);
}
