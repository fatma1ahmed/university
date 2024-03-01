package com.fatma.university.reposity;

import com.fatma.university.model.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article,Long> {
    List<Article> findAllBySourceDepartmentId(long departmentId);
}
