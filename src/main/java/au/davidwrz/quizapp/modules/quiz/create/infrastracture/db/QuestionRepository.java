package au.davidwrz.quizapp.modules.quiz.create.infrastracture.db;

import au.davidwrz.quizapp.modules.quiz.create.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
