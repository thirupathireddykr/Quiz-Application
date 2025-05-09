package com.quizApplication.quizapp.dao;

import com.quizApplication.quizapp.Modal.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
