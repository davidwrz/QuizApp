package au.davidwrz.quizapp.modules.question.create.application;

import au.davidwrz.quizapp.modules.question.create.domain.Answer;
import au.davidwrz.quizapp.utils.mapper.EntityMapper;
import org.springframework.stereotype.Service;

@Service
class AddAnswerDtoMapper implements EntityMapper<Answer, AddQuestionDto.AddAnswerDto> {

    @Override
    public Answer toEntity(AddQuestionDto.AddAnswerDto addAnswerDto) {
        return Answer.of(addAnswerDto.answer(), addAnswerDto.correct());
    }
}
