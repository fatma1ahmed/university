package com.fatma.university.repository;

import com.fatma.university.model.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepo extends JpaRepository<Video,Long> {
    List<Video> findAllBySourceDepartmentId(long departmentId);
}
