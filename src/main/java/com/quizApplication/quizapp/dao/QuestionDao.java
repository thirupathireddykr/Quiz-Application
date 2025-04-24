package com.quizApplication.quizapp.dao;

import com.quizApplication.quizapp.Modal.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String cat);

    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RAND();", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(@Param("category") String category, Pageable pageable);
}
