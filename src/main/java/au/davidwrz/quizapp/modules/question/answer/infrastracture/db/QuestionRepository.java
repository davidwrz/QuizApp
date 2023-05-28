package au.davidwrz.quizapp.modules.question.answer.infrastracture.db;

import au.davidwrz.quizapp.modules.question.answer.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<Question, Integer> {

}