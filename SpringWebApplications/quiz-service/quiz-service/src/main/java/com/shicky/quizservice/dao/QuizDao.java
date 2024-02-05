package com.shicky.quizservice.dao;


import com.shicky.quizservice.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

    Optional<Quiz> findById(Integer id);
}