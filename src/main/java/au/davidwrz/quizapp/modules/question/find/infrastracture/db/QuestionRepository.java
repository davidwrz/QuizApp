package au.davidwrz.quizapp.modules.question.find.infrastracture.db;

import au.davidwrz.quizapp.modules.question.find.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

interface QuestionRepository extends JpaRepository<Question, Integer> {
}