package au.davidwrz.quizapp.modules.question.generate.application;

import au.davidwrz.quizapp.modules.question.create.application.AddQuestionDto;
import au.davidwrz.quizapp.utils.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerateQuestionDtoMapper implements DtoMapper<GenerateQuestionDto, AddQuestionDto> {

    private final GenerateAnswerDtoMapper answerMapper;

    GenerateQuestionDtoMapper(GenerateAnswerDtoMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    @Override
    public AddQuestionDto toDto(GenerateQuestionDto generateQuestionDto) {
        List<AddQuestionDto.AddAnswerDto> answers = generateQuestionDto
                .answers()
                .stream()
                .map(answerMapper::toDto)
                .toList();

        return new AddQuestionDto(generateQuestionDto.content(), answers);
    }
}
