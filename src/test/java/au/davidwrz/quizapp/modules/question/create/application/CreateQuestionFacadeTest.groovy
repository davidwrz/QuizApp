package au.davidwrz.quizapp.modules.question.create.application

import au.davidwrz.quizapp.modules.question.create.domain.Answer
import au.davidwrz.quizapp.modules.question.create.domain.Question
import au.davidwrz.quizapp.modules.question.create.infrastracture.db.RepositoryGateway
import spock.lang.Specification

class CreateQuestionFacadeTest extends Specification {

    def repositoryGateway = Mock(RepositoryGateway)
    def addQuestionDtoMapper = Mock(AddQuestionDtoMapper)
    def addAnswerDtoMapper = new AddAnswerDtoMapper()
    def createQuestionFacade = new CreateQuestionFacade(repositoryGateway, addQuestionDtoMapper, addAnswerDtoMapper)

    def "should add a question when there are four answers with only one correct answer"() {
        given:
        def questionDto = new AddQuestionDto(
                "What is the capital of Australia?",
                [new AddQuestionDto.AddAnswerDto("Brisbane", false),
                 new AddQuestionDto.AddAnswerDto("Sydney", false),
                 new AddQuestionDto.AddAnswerDto("Canberra", true),
                 new AddQuestionDto.AddAnswerDto("Melbourne", false)]
        )
        def question = Question.of("What is the capital of Australia?")
        def answers = [
                Answer.of("Brisbane", false),
                Answer.of("Sydney", false),
                Answer.of("Canberra", true),
                Answer.of("Melbourne", false),
        ]
        question.answers = answers

        when:
        createQuestionFacade.add(questionDto)

        then:
        addQuestionDtoMapper.toEntity(questionDto) >> question
        1 * repositoryGateway.saveQuestion(question, _ as Iterable<Answer>)
    }

    def "should throw exception when no answer is correct"() {
        given:
        def questionDto = new AddQuestionDto(
                "What is the capital of Australia?",
                [new AddQuestionDto.AddAnswerDto("Brisbane", false),
                 new AddQuestionDto.AddAnswerDto("Sydney", false),
                 new AddQuestionDto.AddAnswerDto("Canberra", false),
                 new AddQuestionDto.AddAnswerDto("Melbourne", false)]
        )
        def question = Question.of("What is the capital of Australia?")
        def answers = [
                Answer.of("Brisbane", false),
                Answer.of("Sydney", false),
                Answer.of("Canberra", false),
                Answer.of("Melbourne", false),
        ]
        question.answers = answers

        when:
        createQuestionFacade.add(questionDto)

        then:
        thrown InvalidQuestionException
    }
}
