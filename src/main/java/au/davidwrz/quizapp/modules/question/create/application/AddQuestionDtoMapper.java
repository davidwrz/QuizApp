package au.davidwrz.quizapp.modules.question.create.infrastracture.web;

import au.davidwrz.quizapp.modules.question.create.domain.Answer;
import au.davidwrz.quizapp.modules.question.create.domain.Question;
import au.davidwrz.quizapp.modules.question.delete.infrastracture.web.Mapper;
import au.davidwrz.quizapp.utils.torefactor.GetQuestionDto;
import org.springframework.stereotype.Service;

@Service
public class AddQuestionDtoMapper implements Mapper<> {

    public GetQuestionDto toResponseDto(Question question) {
        return GetQuestionDto.of(question.getContent(), question.getAnswers());
    }

    public Question toQuestionEntity(AddQuestionDto questionDto) {
        return Question.of(questionDto.getContent());
    }

    public Answer toAnswerEntity(AddQuestionDto.AnswerRequestDto answerRequestDto) {
        return Answer.of(answerRequestDto.answer(), answerRequestDto.correct());
    }
}
