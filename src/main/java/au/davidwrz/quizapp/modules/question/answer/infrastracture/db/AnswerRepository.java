package au.davidwrz.quizapp.modules.question.answer.infrastracture.db;

import au.davidwrz.quizapp.modules.question.answer.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}