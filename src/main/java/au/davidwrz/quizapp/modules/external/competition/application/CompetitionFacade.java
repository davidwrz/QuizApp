package au.davidwrz.quizapp.modules.external.competition.application;

import au.davidwrz.quizapp.modules.external.competition.domain.Attempt;
import au.davidwrz.quizapp.modules.external.competition.domain.Competition;
import au.davidwrz.quizapp.modules.external.competition.infrastructure.db.RepositoryGateway;
import org.springframework.stereotype.Service;

@Service
public class CompetitionFacade {

    private final RepositoryGateway repositoryGateway;
    private final CompetitionMapper mapper;

    CompetitionFacade(RepositoryGateway repositoryGateway, CompetitionMapper mapper) {
        this.repositoryGateway = repositoryGateway;
        this.mapper = mapper;
    }

    public void save(CompetitionDto competitionDto) {
        Competition competition = mapper.mapCompetitionToEntity(competitionDto);
        Attempt attempt = mapper.getMappedAttempt();
        if (!repositoryGateway.alreadyAttempted(competitionDto.getQuestionId())) {
            repositoryGateway.saveCompetition(competition, attempt);
        }
    }
}
