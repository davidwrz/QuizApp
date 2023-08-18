package au.davidwrz.quizapp.modules.external.opentdb.question.domain;

import au.davidwrz.quizapp.modules.external.opentdb.question.application.GeneratedQuestion;
import au.davidwrz.quizapp.modules.external.opentdb.question.application.QuestionDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class QuestionGenerator {

    private final GenerateQuestionCaller generateQuestionCaller;

    QuestionGenerator(GenerateQuestionCaller generateQuestionCaller) {
        this.generateQuestionCaller = generateQuestionCaller;
    }

    public QuestionDto generate() {
        GeneratedQuestion generatedQuestion = generateQuestionCaller
                .generateQuestionFromOpenTDB()
                .getGeneratedQuestion();
        return transformToQuestionDto(generatedQuestion);
    }

    private QuestionDto transformToQuestionDto(GeneratedQuestion generatedQuestion) {
        List<QuestionDto.AnswerDto> answerDtoList = Stream.concat(
                Stream.of(new QuestionDto.AnswerDto(generatedQuestion.correctAnswer(), true)),
                Stream.of(generatedQuestion.incorrectAnswers())
                        .map(incorrectAnswer -> new QuestionDto.AnswerDto(incorrectAnswer, false))
        ).toList();
        return QuestionDto.of(generatedQuestion.question(), answerDtoList);
    }
}
