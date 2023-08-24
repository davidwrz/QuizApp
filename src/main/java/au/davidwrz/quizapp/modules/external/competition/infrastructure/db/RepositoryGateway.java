package au.davidwrz.quizapp.modules.external.competition.infrastructure.db;

import au.davidwrz.quizapp.modules.external.competition.domain.Attempt;
import au.davidwrz.quizapp.modules.external.competition.domain.Competition;
import org.springframework.stereotype.Service;

@Service("saveCompetitionRepositoryGateway")
public class RepositoryGateway {

    private final AttemptRepository attemptRepository;
    private final CompetitionRepository competitionRepository;

    public RepositoryGateway(AttemptRepository attemptRepository, CompetitionRepository competitionRepository) {
        this.attemptRepository = attemptRepository;
        this.competitionRepository = competitionRepository;
    }

    public void saveCompetition(Competition competition, Attempt attempt) {
        competitionRepository.save(competition);
        attemptRepository.save(attempt);
    }

    public boolean alreadyAttempted(Integer questionId) {
        return attemptRepository.existsByQuestionId(questionId);
    }
}
