package au.davidwrz.quizapp.modules.question.generate.application

import spock.lang.Specification

class GenerateQuestionDtoMapperTest extends Specification {

    def "should map generated question to addQuestionDto"() {
        given:
        def answerMapper = new GenerateAnswerDtoMapper()
        def questionMapper = new GenerateQuestionDtoMapper(answerMapper)
        def generateQuestionDto = new GenerateQuestionDto("What is the capital of Australia?",
                List.of(new GenerateQuestionDto.GenerateAnswerDto("Sydney", false),
                        new GenerateQuestionDto.GenerateAnswerDto("Melbourne", false),
                        new GenerateQuestionDto.GenerateAnswerDto("Canberra", true),
                        new GenerateQuestionDto.GenerateAnswerDto("Brisbane", false),
                ))

        when:
        def addQuestionDto = questionMapper.toDto(generateQuestionDto)

        then:
        addQuestionDto.content == "What is the capital of Australia?"
        addQuestionDto.answers.get(0).answer() == "Sydney"
        !addQuestionDto.answers.get(0).correct()
        addQuestionDto.answers.get(1).answer() == "Melbourne"
        !addQuestionDto.answers.get(1).correct()
        addQuestionDto.answers.get(2).answer() == "Canberra"
        addQuestionDto.answers.get(2).correct()
        addQuestionDto.answers.get(3).answer() == "Brisbane"
        !addQuestionDto.answers.get(3).correct()
    }
}
