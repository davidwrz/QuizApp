package au.davidwrz.quizapp.modules.external.competition.application


import spock.lang.Specification

import java.time.LocalDateTime

class CompetitionMapperTest extends Specification {

    def mapper = new CompetitionMapper()

    def "should map Competition dto to entity"() {
        given:
        def userId = 1
        def questionId = 1
        def correct = true
        def time = LocalDateTime.now()
        def competitionDto = new CompetitionDto(userId, questionId, correct, time)

        when:
        def competition = mapper.mapCompetitionToEntity(competitionDto)

        then:
        def attempt = competition.attempts.getAt(0)
        attempt.questionId == questionId
        attempt.correct == correct
        attempt.attemptTimestamp == time
        competition.userId == userId

    }
}
