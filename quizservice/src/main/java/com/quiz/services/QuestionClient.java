package com.quiz.services;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.entities.Questions;

//@FeignClient(url ="http://localhost:8082",value="questionservice")
@FeignClient(name="QUESTIONSERVICE")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
    List<Questions> getQuestionsOfQuiz(@PathVariable Long quizId);

}
