package au.davidwrz.quizapp.modules.question.delete.infrastracture.db;

import au.davidwrz.quizapp.modules.question.delete.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("deleteQuestionRepository")
interface QuestionRepository extends JpaRepository<Question, Integer> {

}