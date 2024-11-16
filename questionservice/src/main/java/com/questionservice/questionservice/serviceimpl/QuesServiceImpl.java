package com.questionservice.questionservice.serviceimpl;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionservice.questionservice.entites.Questions;
import com.questionservice.questionservice.repostitories.QuestionRepository;
import com.questionservice.questionservice.service.QuesService;

@Service
public class QuesServiceImpl implements QuesService {

    private QuestionRepository questionRepository;

    public QuesServiceImpl(QuestionRepository questionRepository){
        this.questionRepository=questionRepository;
    }

    @Override
    public Questions create(Questions questions) {
        return questionRepository.save(questions);
    }

    @Override
    public List<Questions> get() {
        return questionRepository.findAll();
    }

    @Override
    public Questions getOne(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
    }

    @Override
    public List<Questions> getQuestionsofQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    

}
