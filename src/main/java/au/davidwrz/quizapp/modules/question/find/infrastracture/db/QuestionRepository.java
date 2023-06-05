package au.davidwrz.quizapp.modules.question.find.infrastracture.db;

import au.davidwrz.quizapp.modules.question.find.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("FindQuestionRepository")
interface QuestionRepository extends JpaRepository<Question, Integer> {
}