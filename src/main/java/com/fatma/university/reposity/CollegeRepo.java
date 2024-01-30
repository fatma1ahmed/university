package com.fatma.university.reposity;

import com.fatma.university.model.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepo extends JpaRepository<College,Long> {
}
