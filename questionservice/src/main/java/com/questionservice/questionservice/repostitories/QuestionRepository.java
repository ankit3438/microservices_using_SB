package com.questionservice.questionservice.repostitories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.questionservice.questionservice.entites.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions,Long> {

    List<Questions> findByQuizId(Long quizId);

}
