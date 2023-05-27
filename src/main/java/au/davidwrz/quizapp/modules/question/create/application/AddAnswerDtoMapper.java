package au.davidwrz.quizapp.modules.question.create.application;

import au.davidwrz.quizapp.modules.question.create.domain.Question;
import au.davidwrz.quizapp.modules.question.create.infrastracture.web.AddQuestionDto;
import au.davidwrz.quizapp.utils.mapper.Mapper;
import org.springframework.stereotype.Service;

@Service
class AddAnswerMapper implements Mapper<Question, AddQuestionDto.AnswerRequestDto> {

    @Override
    public Question toEntity(AddQuestionDto.AnswerRequestDto answerRequestDto) {
        return null;
    }

    @Override
    public AddQuestionDto.AnswerRequestDto toDto(Question question) {
        return null;
    }
}
