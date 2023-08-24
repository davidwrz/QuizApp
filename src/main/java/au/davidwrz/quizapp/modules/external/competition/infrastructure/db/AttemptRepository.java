package au.davidwrz.quizapp.modules.external.competition.infrastructure.db;

import au.davidwrz.quizapp.modules.external.competition.domain.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;

interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    boolean existsByQuestionId(Integer questionId);
}
