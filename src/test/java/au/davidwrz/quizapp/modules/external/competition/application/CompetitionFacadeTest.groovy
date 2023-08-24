package au.davidwrz.quizapp.modules.external.competition.application

import au.davidwrz.quizapp.modules.external.competition.domain.Attempt
import au.davidwrz.quizapp.modules.external.competition.domain.Competition
import au.davidwrz.quizapp.modules.external.competition.infrastructure.db.RepositoryGateway
import spock.lang.Specification

import java.time.LocalDateTime

class CompetitionFacadeTest extends Specification {

    def mapper = Mock(CompetitionMapper)
    def repositoryGateway = Mock(RepositoryGateway)
    def competitionFacade = new CompetitionFacade(repositoryGateway, mapper)

    def "should save competition"() {
        given:
        def userId = 1
        def questionId = 1
        def correct = true
        def time = LocalDateTime.now()
        def competitionDto = new CompetitionDto(userId, questionId, correct, time)

        def attempt = new Attempt(questionId, correct, time)
        def competition = new Competition(userId: userId)

        when:
        mapper.mapCompetitionToEntity(competitionDto) >> competition
        mapper.getMappedAttempt() >> attempt
        competitionFacade.save(competitionDto)

        then:
        1 * repositoryGateway.saveCompetition(competition, attempt)
    }
}
