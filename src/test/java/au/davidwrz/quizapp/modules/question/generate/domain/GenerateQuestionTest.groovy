package au.davidwrz.quizapp.modules.question.generate.domain

import au.davidwrz.quizapp.modules.question.create.application.AddQuestionDto
import au.davidwrz.quizapp.modules.question.create.application.CreateQuestionFacade
import au.davidwrz.quizapp.modules.question.generate.application.GenerateQuestionDto
import au.davidwrz.quizapp.modules.question.generate.application.GenerateQuestionDtoMapper
import au.davidwrz.quizapp.modules.user.register.domain.User
import spock.lang.Specification

class GenerateQuestionTest extends Specification {

    def "should generate question from external api"() {
        given:
        def mapper = Mock(GenerateQuestionDtoMapper)
        def apiCaller = Mock(ExternalApiCaller)
        def createQuestionFacade = Mock(CreateQuestionFacade)
        def generateQuestion = new GenerateQuestion(mapper, apiCaller, createQuestionFacade)
        def user = Mock(User)
        def token = "exampleJwtToken"

        def generateQuestionDto = new GenerateQuestionDto("What is the capital of Australia?",
                List.of(new GenerateQuestionDto.GenerateAnswerDto("Sydney", false),
                        new GenerateQuestionDto.GenerateAnswerDto("Melbourne", false),
                        new GenerateQuestionDto.GenerateAnswerDto("Canberra", true),
                        new GenerateQuestionDto.GenerateAnswerDto("Brisbane", false),
                ))
        def addQuestionDto = new AddQuestionDto("What is the capital of Australia?",
                List.of(new AddQuestionDto.AddAnswerDto("Sydney", false),
                        new AddQuestionDto.AddAnswerDto("Melbourne", false),
                        new AddQuestionDto.AddAnswerDto("Canberra", true),
                        new AddQuestionDto.AddAnswerDto("Brisbane", false),
                ))

        apiCaller.generateQuestion(token) >> generateQuestionDto
        mapper.toDto(generateQuestionDto) >> addQuestionDto

        when:
        generateQuestion.generateQuestionFromExternalApi(user, token)

        then:
        1 * createQuestionFacade.add(addQuestionDto, user)
    }
}
