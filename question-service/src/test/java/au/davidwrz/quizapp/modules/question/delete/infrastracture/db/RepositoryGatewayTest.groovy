package au.davidwrz.quizapp.modules.question.delete.infrastracture.db

import spock.lang.Specification

class RepositoryGatewayTest extends Specification {

    def questionRepository = Mock(QuestionRepository)
    def repositoryGateway = new RepositoryGateway(questionRepository)

    def "should remove question when exists"() {
        given:
        def questionId = 1

        when:
        repositoryGateway.deleteQuestion(questionId)

        then:
        1 * questionRepository.deleteById(questionId)
    }
}
