package au.davidwrz.quizapp.repository;

import au.davidwrz.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<Question, Integer> {

}