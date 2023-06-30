package au.davidwrz.quizapp.modules.quiz.create.infrastracture.db;

import au.davidwrz.quizapp.modules.quiz.create.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
