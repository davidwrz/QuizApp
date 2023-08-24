package au.davidwrz.quizapp.modules.external.competition.infrastructure.db

import au.davidwrz.quizapp.modules.external.competition.domain.Attempt
import au.davidwrz.quizapp.modules.external.competition.domain.Competition
import spock.lang.Specification

class RepositoryGatewayTest extends Specification {

    def attemptRepository = Mock(AttemptRepository)
    def competitionRepository = Mock(CompetitionRepository)
    def repositoryGateway = new RepositoryGateway(attemptRepository, competitionRepository)

    def "should save competition and attempt to repository"() {
        given:
        def competition = new Competition()
        def attempt = new Attempt()
        when:

        repositoryGateway.saveCompetition(competition,attempt)

        then:
        1 * attemptRepository.save(attempt)
        1 * competitionRepository.save(competition)
    }
}
