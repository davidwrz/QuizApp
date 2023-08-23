package au.davidwrz.quizapp.modules.question.answer.domain

import au.davidwrz.quizapp.modules.question.answer.application.AnswerQuestionDto
import au.davidwrz.quizapp.modules.question.answer.application.AnswerResult
import org.springframework.context.ApplicationEventPublisher
import spock.lang.Specification

class AnswerQuestionTest extends Specification {

    def answerChecker = new AnswerChecker()
    def eventPublisher = Mock(ApplicationEventPublisher)
    def answerQuestion = new AnswerQuestion(answerChecker, eventPublisher)

    def "should return true if question has been correctly answered"() {
        given:
        def question = new Question("Which city is in Australia?",[
                        Answer.of("New York", false),
                        Answer.of("Sydney", true),
                        Answer.of("Canberra", true),
                        Answer.of("Tokio", false),
                ])
        def answerQuestionDto = new AnswerQuestionDto(
                answers: [
                        new AnswerQuestionDto.Answer("Sydney"),
                        new AnswerQuestionDto.Answer("Canberra")
                ]
        )

        when:
        def answerResult = answerQuestion.checkAnswer(1, 1, question, answerQuestionDto, "token")

        then:
        answerResult.result() == AnswerResult.Result.CORRECT
        1 * eventPublisher.publishEvent(_)
    }

    def "should return false if question has not been correctly answered"() {
        given:
        def question = new Question("Which city is in Australia?",[
                Answer.of("New York", false),
                Answer.of("Sydney", true),
                Answer.of("Canberra", true),
                Answer.of("Tokio", false),
        ])
        def answerQuestionDto = new AnswerQuestionDto(
                answers: [
                        new AnswerQuestionDto.Answer("Sydney"),
                        new AnswerQuestionDto.Answer("Tokio")
                ]
        )

        when:
        def answerResult = answerQuestion.checkAnswer(1, 1, question, answerQuestionDto, "token")

        then:
        answerResult.result() == AnswerResult.Result.FALSE
        1 * eventPublisher.publishEvent(_)
    }
}
