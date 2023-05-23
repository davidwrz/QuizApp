package au.davidwrz.quizapp.repository;

import au.davidwrz.quizapp.model.Answer;
import au.davidwrz.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}