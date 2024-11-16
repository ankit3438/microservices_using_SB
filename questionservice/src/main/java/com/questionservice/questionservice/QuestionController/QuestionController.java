package com.questionservice.questionservice.QuestionController;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionservice.questionservice.entites.Questions;
import com.questionservice.questionservice.serviceimpl.QuesServiceImpl;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuesServiceImpl quesServiceImpl;

    public QuestionController(QuesServiceImpl quesServiceImpl){
        this.quesServiceImpl=quesServiceImpl;
    }

    @PostMapping
    public Questions create(@RequestBody Questions questions){
        return quesServiceImpl.create(questions);
    }

    @GetMapping
    public List<Questions> get(){
        return quesServiceImpl.get();
    }

    @GetMapping("/{id}")
    public Questions getOne(@PathVariable Long id){
        return quesServiceImpl.getOne(id);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Questions> getQuestionsOfQuiz(@PathVariable Long quizId){
        return quesServiceImpl.getQuestionsofQuizId(quizId);
    }

}
