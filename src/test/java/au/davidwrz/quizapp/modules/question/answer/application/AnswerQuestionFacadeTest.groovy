package au.davidwrz.quizapp.modules.question.answer.application

import au.davidwrz.quizapp.modules.question.create.domain.Answer
import au.davidwrz.quizapp.modules.question.find.application.FindQuestionFacade
import au.davidwrz.quizapp.modules.question.find.domain.Question
import spock.lang.Specification

class AnswerQuestionFacadeTest extends Specification {

    def answerChecker = new AnswerChecker()
    def findQuestionFacade = Mock(FindQuestionFacade)
    def questionMapper = new QuestionMapper()
    def answerQuestionFacade = new AnswerQuestionFacade(answerChecker, findQuestionFacade, questionMapper)

    def "should return true if question has been correctly answered"() {
        given:
        def question = new Question(
                id: 1,
                content: "Which city is in Australia?",
                answers: [
                        Answer.of("New York", false),
                        Answer.of("Sydney", true),
                        Answer.of("Canberra", true),
                        Answer.of("Tokio", false),
                ]
        )
        def answerQuestionDto = new AnswerQuestionDto(
                answers: [
                        new AnswerQuestionDto.Answer("Sydney"),
                        new AnswerQuestionDto.Answer("Canberra")
                ]
        )

        when:
        def answerResult = answerQuestionFacade.answer(1,answerQuestionDto)

        then:
        findQuestionFacade.findById(1) >> question
        answerResult.result() == AnswerResult.Result.CORRECT
    }

    def "should return false if question has not been correctly answered"() {
        given:
        def question = new Question(
                id: 1,
                content: "Which city is in Australia?",
                answers: [
                        Answer.of("New York", false),
                        Answer.of("Sydney", true),
                        Answer.of("Canberra", true),
                        Answer.of("Tokio", false),
                ]
        )
        def answerQuestionDto = new AnswerQuestionDto(
                answers: [
                        new AnswerQuestionDto.Answer("Sydney"),
                        new AnswerQuestionDto.Answer("Tokio")
                ]
        )

        when:
        def answerResult = answerQuestionFacade.answer(1,answerQuestionDto)

        then:
        findQuestionFacade.findById(1) >> question
        answerResult.result() == AnswerResult.Result.FALSE
    }
}
