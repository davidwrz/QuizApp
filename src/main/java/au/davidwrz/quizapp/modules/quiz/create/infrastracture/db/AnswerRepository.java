package au.davidwrz.quizapp.modules.quiz.create.infrastracture.db;

import au.davidwrz.quizapp.modules.quiz.create.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("repo1")
public interface AnswerRepository extends JpaRepository <Answer, Integer> {
}
