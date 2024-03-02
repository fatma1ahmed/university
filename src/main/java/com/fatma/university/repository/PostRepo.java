package com.fatma.university.repository;

import com.fatma.university.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {

    List<Post>findAllBySourceDepartmentId(long departmentId);
}
