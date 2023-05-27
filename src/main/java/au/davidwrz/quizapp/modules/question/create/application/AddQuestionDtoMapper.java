package au.davidwrz.quizapp.modules.question.create.application;

import au.davidwrz.quizapp.modules.question.create.domain.Question;
import au.davidwrz.quizapp.modules.question.create.infrastracture.web.AddQuestionDto;
import au.davidwrz.quizapp.utils.mapper.DtoMapper;
import au.davidwrz.quizapp.utils.mapper.EntityMapper;
import org.springframework.stereotype.Service;

@Service
class AddQuestionDtoMapper implements EntityMapper<Question,AddQuestionDto> {

    @Override
    public Question toEntity(AddQuestionDto addQuestionDto) {
        return Question.of(addQuestionDto.getContent());
    }
}
