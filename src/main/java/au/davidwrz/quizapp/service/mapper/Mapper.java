package au.davidwrz.quizapp.service.mapper;

import au.davidwrz.quizapp.model.Answer;
import au.davidwrz.quizapp.model.Question;
import au.davidwrz.quizapp.model.dto.AddQuestionDto;
import au.davidwrz.quizapp.model.dto.GetQuestionDto;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

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
