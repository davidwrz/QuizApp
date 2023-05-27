package au.davidwrz.quizapp.modules.question.create.infrastracture.db;

import au.davidwrz.quizapp.modules.question.create.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}