package au.davidwrz.quizapp.modules.question.find.infrastracture.db

import spock.lang.Specification

class RepositoryGatewayTest extends Specification {

    def questionRepository = Mock(QuestionRepository)
    def repositoryGateway = new RepositoryGateway(questionRepository)

    def "should throw exception when question does not exist"() {
        given:
        def questionId = 1
        when:
        repositoryGateway.findById(questionId)
        then:
        questionRepository.findById(questionId) >> Optional.empty()
        thrown(QuestionNotFoundException)
    }
}
