package au.davidwrz.quizapp.modules.question.find.application

import au.davidwrz.quizapp.modules.question.create.domain.Answer
import au.davidwrz.quizapp.modules.question.find.domain.Question
import au.davidwrz.quizapp.modules.question.find.infrastracture.db.RepositoryGateway
import spock.lang.Specification

class FindQuestionFacadeTest extends Specification {

    def repositoryGateway = Mock(RepositoryGateway)
    def findQuestionFacade = new FindQuestionFacade(repositoryGateway)

    def "should find question by id when exists"() {
        given:
        def questionId = 1
        def question = new Question(
                id: questionId,
                content: "Which city is in Australia?",
                answers: [
                        Answer.of("New York", false),
                        Answer.of("Sydney", true),
                        Answer.of("Canberra", true),
                        Answer.of("Tokio", false),
                ]
        )
        when:
        def questionResult = findQuestionFacade.findById(questionId)
        then:
        repositoryGateway.findById(questionId) >> question
        questionResult == question
    }
}
