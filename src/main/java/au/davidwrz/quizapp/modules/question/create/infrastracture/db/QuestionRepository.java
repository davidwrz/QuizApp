package au.davidwrz.quizapp.modules.question.create.infrastracture.db;

import au.davidwrz.quizapp.modules.question.create.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CREATE_QUESTION_QUESTION_REPOSITORY")
interface QuestionRepository extends JpaRepository<Question, Integer> {

}