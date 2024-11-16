package com.quiz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.services.QuizServices;

@Service
public class QuizServiceImpl implements QuizServices {
    @Autowired
    private QuizRepository repo;

    @Override
    public Quiz add(Quiz quiz) {
        return repo.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        return repo.findAll();
    }

    @Override
    public Quiz get(Long id) {
        return repo.findById(id).orElseThrow(()-> new RuntimeException("quiz not found"));
    }

}
