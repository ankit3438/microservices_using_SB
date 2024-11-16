package com.questionservice.questionservice.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.questionservice.questionservice.entites.Questions;

@Service
public interface QuesService {
    Questions create(Questions questions);
    List<Questions> get();
    Questions getOne(Long id);
    List<Questions> getQuestionsofQuizId(Long quizId);
}
