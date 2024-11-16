package com.quiz.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizServices;

@Service
public class QuizServiceImpl implements QuizServices {
    private QuizRepository repo;
    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository repo, QuestionClient questionClient){
        this.repo=repo;
        this.questionClient=questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return repo.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = repo.findAll();
        List<Quiz> newQuizList=quizzes.stream().map(quiz->{
            quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz= repo.findById(id).orElseThrow(()-> new RuntimeException("quiz not found"));
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }

}
