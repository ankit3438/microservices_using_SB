package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.services.impl.QuizServiceImpl;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizServiceImpl quizServiceImpl;

    public QuizController(QuizServiceImpl quizServiceImpl){
        this.quizServiceImpl=quizServiceImpl;
    }

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return quizServiceImpl.add(quiz);
    }

    @GetMapping
    public List<Quiz> get(){
        return quizServiceImpl.get();
    }

    @GetMapping("/{id}")
    public Quiz get(@PathVariable Long id){
        return quizServiceImpl.get(id);
    }


}
