package au.davidwrz.quizapp.modules.question.generate.application;

import au.davidwrz.quizapp.modules.question.create.application.AddQuestionDto;
import au.davidwrz.quizapp.utils.mapper.DtoMapper;
import org.springframework.stereotype.Service;

@Service
class GenerateAnswerDtoMapper implements DtoMapper<GenerateQuestionDto.GenerateAnswerDto, AddQuestionDto.AddAnswerDto> {

    @Override
    public AddQuestionDto.AddAnswerDto toDto(GenerateQuestionDto.GenerateAnswerDto generateAnswerDto) {
        return new AddQuestionDto.AddAnswerDto(generateAnswerDto.answer(), generateAnswerDto.correct());
    }
}
