package au.davidwrz.quizapp.modules.question.delete.application

import au.davidwrz.quizapp.modules.question.create.domain.Answer
import au.davidwrz.quizapp.modules.question.delete.infrastracture.db.RepositoryGateway
import au.davidwrz.quizapp.modules.question.find.application.FindQuestionFacade
import au.davidwrz.quizapp.modules.question.find.domain.Question
import spock.lang.Specification

class DeleteQuestionFacadeTest extends Specification {

    def findQuestionFacade = Mock(FindQuestionFacade)
    def repositoryGateway = Mock(RepositoryGateway)
    def deleteQuestionFacade = new DeleteQuestionFacade(findQuestionFacade, repositoryGateway)

    def "should delete question when exists"() {
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
        deleteQuestionFacade.deleteQuestion(questionId)

        then:
        findQuestionFacade.findById(questionId) >> question
        1 * repositoryGateway.deleteQuestion(questionId)
    }
}
