package au.davidwrz.quizapp.modules.question.create.infrastracture.db;

import au.davidwrz.quizapp.modules.question.create.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CREATE_QUESTION_ANSWER_REPOSITORY")
interface AnswerRepository extends JpaRepository<Answer, Integer> {
}