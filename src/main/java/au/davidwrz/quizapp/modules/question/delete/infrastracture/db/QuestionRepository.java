package au.davidwrz.quizapp.modules.question.create.infrastracture.db;

import au.davidwrz.quizapp.modules.question.create.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<Question, Integer> {

}