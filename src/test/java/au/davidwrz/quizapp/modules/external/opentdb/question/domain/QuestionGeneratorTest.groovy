package au.davidwrz.quizapp.modules.external.opentdb.question.domain

import au.davidwrz.quizapp.modules.external.opentdb.question.application.GeneratedQuestion
import au.davidwrz.quizapp.modules.external.opentdb.question.application.QuestionApiResponse
import spock.lang.Specification

class QuestionGeneratorTest extends Specification {

    def "should generate a valid question DTO with answers"() {
        given:
        def generateQuestionCaller = Mock(GenerateQuestionCaller)
        def questionGenerator = new QuestionGenerator(generateQuestionCaller)
        def generatedQuestion = new GeneratedQuestion(
                "What is the capital of France?",
                "Paris",
                new String[]{"London", "Rome", "Berlin"}
        )
        def apiResponse = new QuestionApiResponse(generatedQuestions: List.of(generatedQuestion))

        when:
        generateQuestionCaller.generateQuestionFromOpenTDB() >> apiResponse
        def questionDto = questionGenerator.generate()

        then:
        questionDto
        questionDto.content == "What is the capital of France?"
        questionDto.answers[0].answer == "Paris"
        questionDto.answers[0].correct()
        questionDto.answers[1].answer == "London"
        !questionDto.answers[1].correct()
        questionDto.answers[2].answer == "Rome"
        !questionDto.answers[2].correct()
        questionDto.answers[3].answer == "Berlin"
        !questionDto.answers[3].correct()
    }
}
