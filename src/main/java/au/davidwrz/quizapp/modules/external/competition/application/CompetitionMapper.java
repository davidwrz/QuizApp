package au.davidwrz.quizapp.modules.external.competition.application;

import au.davidwrz.quizapp.modules.external.competition.domain.Attempt;
import au.davidwrz.quizapp.modules.external.competition.domain.Competition;
import org.springframework.stereotype.Service;

@Service
class CompetitionMapper {

    private Attempt attempt;

    public Competition mapCompetitionToEntity(CompetitionDto competitionDto) {
        attempt = Attempt.of(competitionDto.getQuestionId(), competitionDto.isCorrect(), competitionDto.getTime());
        Competition competition = Competition.of(competitionDto.getUserId());
        attempt.setCompetition(competition);
        competition.addAttempt(attempt);
        return competition;
    }

    public Attempt getMappedAttempt() {
        return attempt;
    }
}
