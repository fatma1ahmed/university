package com.fatma.university.reposity;

import com.fatma.university.model.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepo extends JpaRepository<Source,Long> {
}
